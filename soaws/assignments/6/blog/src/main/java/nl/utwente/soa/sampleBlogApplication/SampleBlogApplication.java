package nl.utwente.soa.sampleBlogApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SampleBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(SampleBlogApplication.class, args);
    }
}
