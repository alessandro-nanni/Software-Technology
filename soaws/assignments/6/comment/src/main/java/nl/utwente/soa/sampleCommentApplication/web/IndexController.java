package nl.utwente.soa.sampleCommentApplication.web;

import nl.utwente.soa.sampleCommentApplication.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments/{blogId}")
    public String showComments(Model model, @PathVariable("blogId") Long blogId) {
        model.addAttribute("comments", commentService.getCommentsForBlog(blogId));
        return "detail";
    }
}
