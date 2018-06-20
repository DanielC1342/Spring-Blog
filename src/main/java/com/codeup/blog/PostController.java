package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
    private final PostService postsvc;

    public PostController(PostService postsvc) {
        this.postsvc = postsvc;
    }

    @GetMapping("/posts")
    public String postIndex(Model model) {
        model.addAttribute("list",postsvc.all());
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String postIndexId(@PathVariable int id, Model model) {
        model.addAttribute("post",postsvc.find(id));
        return "posts/show";
    }
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable int id, Model model) {
        model.addAttribute("post",postsvc.find(id));
        return "posts/edit";
    }

    @GetMapping("/posts/create")
    public String createPost(Model model) {
        model.addAttribute("post",new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String showCreatedPost(
        @RequestParam(name = "title") String title,
        @RequestParam(name = "body") String body
    ) {
        Post post = new Post(0,title,body);
        postsvc.save(post);
        return "redirect:/posts";
    }
}
