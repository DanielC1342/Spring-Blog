package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        model.addAttribute("post",postsvc.find(0));
        return "posts/show";
    }
    @GetMapping("/posts/create")
    public @ResponseBody String createPost() {
        return "Here is the form for creating a new post";
    }
    @PostMapping("/posts/create")
    public @ResponseBody String showCreatedPost() {
        return "create a new post";
    }
}
