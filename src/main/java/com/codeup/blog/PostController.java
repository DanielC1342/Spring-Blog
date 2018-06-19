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

    @GetMapping("/posts")
    public String postIndex(Model model) {
        Post postA = new Post("This is post A","Here is the body of post A");
        Post postB = new Post("This is post B","Here is the body of post B");
        Post postC = new Post("This is post C","Here is the body of post C");
        ArrayList<Post> list = new ArrayList<>();
        list.add(postA);
        list.add(postB);
        list.add(postC);
        model.addAttribute("list",list);
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String postIndexId(@PathVariable int id, Model model) {
        Post post = new Post("This is a Post","Here is the body of the post");
        model.addAttribute("post",post);
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
