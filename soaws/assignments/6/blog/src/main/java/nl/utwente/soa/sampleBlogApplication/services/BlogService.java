package nl.utwente.soa.sampleBlogApplication.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.utwente.soa.sampleBlogApplication.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class BlogService {
    private static List<Blog> blogs = new ArrayList<>();

    @Autowired
    private BlogPluginService blogPluginService;

    @PostConstruct
    public void blogSetup() {
        blogs.add(
                new Blog(
                        1L,
                        "Test Blog 1",
                        "Summary1",
                        "Content 1"
                )
        );
        blogs.add(
                new Blog(
                        2L,
                        "Test Blog 2",
                        "summary 2",
                        "Content 2"
                )
        );
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public Blog getBlogById(Long id) {
        return blogs.stream().filter(blog -> Objects.equals(blog.getId(), id)).findFirst().orElse(null);
    }

    public void deleteBlogById(Long id) {
        if (blogPluginService.canDeleteBlog(id)) {
            blogPluginService.confirmDeleteBlog(id);
            blogs.removeIf(blog -> Objects.equals(blog.getId(), id));
            System.out.println("Blog " + id + " successfully deleted.");
        } else {
            System.err.println("Deletion aborted: A plugin vetoed the deletion of blog " + id);
            throw new RuntimeException("Cannot delete blog: Subscribed plugins rejected the deletion.");
        }
    }
}
