package nl.utwente.soa.sampleCommentApplication.services;

import jakarta.annotation.PostConstruct;
import nl.utwente.soa.sampleCommentApplication.domain.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private static final List<Comment> comments = new ArrayList<>();
    @PostConstruct
    public void setup() {
        comments.add(new Comment(1L, "Leon", "Nice blog", 1L));
        comments.add(new Comment(2L, "Leon", "Wow awesome blog", 1L));
        comments.add(new Comment(3L, "Leon", "Stupid post", 2L));
        comments.add(new Comment(4L, "Leon", "Test 2", 2L));
        comments.add(new Comment(5L, "Obama", "Test 5", 2L));
    }
    public List<Comment> getCommentsForBlog(Long blogId) {
        return comments.stream()
                .filter(comment -> Objects.equals(comment.getBlogId(), blogId))
                .collect(Collectors.toList());
    }

    public boolean canDeleteBlog(Long blogId) {
        return getCommentsForBlog(blogId).size() <= 1;
    }

    public void deleteCommentsForBlog(Long blogId) {
        comments.removeIf(comment -> Objects.equals(comment.getBlogId(), blogId));
    }
}