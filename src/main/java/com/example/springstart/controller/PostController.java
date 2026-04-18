package com.example.springstart.controller;

import com.example.springstart.domain.Member;
import com.example.springstart.domain.Post;
import com.example.springstart.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping
    public String postList(@RequestParam (required = false, defaultValue = "latest") String sort, Model model) {



        List<Post> posts = postService.findPosts(sort);



        model.addAttribute("posts", posts);
        model.addAttribute("sort", sort);
        return "postList";
    }






    @GetMapping("/new")
    public String postNew(Model model) {
        model.addAttribute("postForm", new PostForm());
        return "postForm";
    }

    @PostMapping("/new")
    public String postNew(@ModelAttribute PostForm postForm, Model model) {

        try{
            postService.writePost(new Post(postForm.getTitle(), postForm.getContent(), postForm.getWriter()));
        }catch(IllegalStateException | IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("postForm", postForm);
            return "postForm";
        }

        return "redirect:/posts";
    }
}
