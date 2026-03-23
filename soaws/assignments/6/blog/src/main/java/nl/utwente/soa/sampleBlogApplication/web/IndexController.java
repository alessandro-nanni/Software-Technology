package nl.utwente.soa.sampleBlogApplication.web;

import nl.utwente.soa.sampleBlogApplication.services.BlogService;
import nl.utwente.soa.sampleBlogApplication.services.BlogPluginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @Autowired private BlogService blogService;
    @Autowired private BlogPluginService blogPluginService;

    @GetMapping("/")
    public String showOverview(Model model) {
        model.addAttribute("blogs", blogService.getBlogs());
        return "overview";
    }

    @GetMapping("/blog/{blogid}")
    public String showBlog(Model model, @PathVariable("blogid") Long blogId) {
        model.addAttribute("blog", blogService.getBlogById(blogId));
        model.addAttribute("plugins", blogPluginService.getPlugins());
        return "detail";
    }

    @GetMapping("/blog/{blogid}/delete")
    public String deleteBlog(@PathVariable("blogid") Long blogId) {
        try {
            blogService.deleteBlogById(blogId);
        } catch (RuntimeException e) {
            System.err.println("Could not delete because of constraints: " + e.getMessage());
            // Optionally, you could redirect to "/blog/{blogid}?error=true" to show a popup
        }
        return "redirect:/";
    }
}
