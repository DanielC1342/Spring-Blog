package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
class PostController {
    private PostRepo postDao;

    public PostController(PostService postsvc, PostRepo postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postIndex(Model model) {
        model.addAttribute("list",postDao.findAll());
        return "posts/index";
    }
    @GetMapping("/posts/{id}")
    public String postIndexId(@PathVariable int id, Model model) {
        model.addAttribute("post",postDao.findOne(id));
        return "posts/show";
    }
    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable int id, Model model) {
        Post edit = postDao.findOne(id);
        model.addAttribute("post", edit);
        model.addAttribute("title",edit.getTitle());
        model.addAttribute("body",edit.getBody());
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(
            @PathVariable int id,
            @RequestParam(name = "nuTitle") String title,
            @RequestParam(name = "nuBody") String body
    ) {
        //some kind of hibernate update query
        postDao.save(postDao.findOne(id));
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable int id) {
        Post foo = postDao.findOne(id);
        postDao.delete(foo);
        return "redirect:/posts";
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
        postDao.save(post);
        return "redirect:/posts";
    }
}
