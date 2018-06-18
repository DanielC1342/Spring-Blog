package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    public @ResponseBody String postIndex() {
        return "Here is the post index";
    }
    @GetMapping("/posts/{id}")
    public @ResponseBody String postIndexId(@PathVariable int id) {
        return String.format("Here is the post with the ID of %d", id);
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
