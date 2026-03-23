package nl.utwente.soa.sampleBlogApplication.web;

import nl.utwente.soa.sampleBlogApplication.services.BlogPluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PluginController {

    @Autowired
    private BlogPluginService pluginService;

    @PostMapping("/subscribe")
    public void subscribe(@RequestParam String name,
                          @RequestParam String url,
                          @RequestParam String healthUrl,
                          @RequestParam String canDeleteUrl,
                          @RequestParam String confirmDeleteUrl) {

        pluginService.addPlugin(name, url, healthUrl, canDeleteUrl, confirmDeleteUrl);
        System.out.println("Plugin registered: " + name + " → " + url + " (health: " + healthUrl + ")");
    }
}