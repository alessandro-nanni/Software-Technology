package nl.utwente.soa.sampleCommentApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import nl.utwente.soa.sampleCommentApplication.services.CommentService;


@SpringBootApplication
public class SampleCommentApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleCommentApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner registerToBlog(RestTemplate restTemplate, @Value("${server.port:8081}") String serverPort) {
        return _ -> {
            try {
                String url = "http://localhost:8080/subscribe?name={name}&url={url}&healthUrl={healthUrl}&canDeleteUrl={canDeleteUrl}&confirmDeleteUrl={confirmDeleteUrl}";
                String myUrl = "http://localhost:" + serverPort + "/comments/";
                String healthUrl = "http://localhost:" + serverPort + "/health";
                String canDeleteUrl = "http://localhost:" + serverPort + "/canDelete/";
                String confirmDeleteUrl = "http://localhost:" + serverPort + "/deleteBlog/";
                restTemplate.postForObject(url, null, Void.class, "comments", myUrl, healthUrl, canDeleteUrl, confirmDeleteUrl);
                System.out.println("Successfully registered to blog service with " + myUrl);
            } catch (Exception e) {
                System.err.println("Failed to register to blog service: " + e.getMessage());
            }
        };
    }

    @RestController
    static class HealthCheckController {
        @GetMapping("/health")
        public String health() {
            return "OK";
        }
    }

    @RestController
    static class TwoPhaseCommitController {
        private final CommentService commentService;

        public TwoPhaseCommitController(CommentService commentService) {
            this.commentService = commentService;
        }

        @GetMapping("/canDelete/{blogId}")
        public boolean canDelete(@PathVariable Long blogId) {
            return commentService.canDeleteBlog(blogId);
        }

        @DeleteMapping("/deleteBlog/{blogId}")
        public void deleteBlog(@PathVariable Long blogId) {
            commentService.deleteCommentsForBlog(blogId);
        }
    }
}
