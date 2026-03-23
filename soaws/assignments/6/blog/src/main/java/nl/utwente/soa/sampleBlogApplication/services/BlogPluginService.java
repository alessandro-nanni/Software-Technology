package nl.utwente.soa.sampleBlogApplication.services;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

@Getter
@Service
public class BlogPluginService {

    private final List<Plugin> plugins = new CopyOnWriteArrayList<>();
    private final RestTemplate restTemplate = new RestTemplate();

    public void addPlugin(String name, String url, String healthUrl, String canDeleteUrl, String confirmDeleteUrl) {
        plugins.add(new Plugin(name, url, healthUrl, canDeleteUrl, confirmDeleteUrl));
    }

    public boolean canDeleteBlog(Long blogId) {
        for (Plugin plugin : plugins) {
            try {
                Boolean canDelete = restTemplate.getForObject(plugin.canDeleteUrl() + blogId, Boolean.class);
                if (canDelete != null && !canDelete) {
                    return false;
                }
            } catch (RestClientException e) {
                return false;
            }
        }
        return true;
    }

    public void confirmDeleteBlog(Long blogId) {
        for (Plugin plugin : plugins) {
            try {
                restTemplate.delete(plugin.confirmDeleteUrl() + blogId);
            } catch (RestClientException e) {
                System.out.println("Failed to notify plugin " + plugin.name() + " about blog deletion.");
            }
        }
    }
    @Scheduled(fixedDelay = 10000)
    public void checkPluginsHealth() {
        plugins.removeIf(plugin -> {
            try {
                restTemplate.getForObject(plugin.healthUrl(), String.class);
                return false;
            } catch (RestClientException e) {
                System.out.println("Plugin " + plugin.name() + " is unreachable. Removing from active plugins.");
                return true;
            }
        });
    }

}