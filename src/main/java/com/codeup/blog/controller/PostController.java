package com.codeup.blog.controller;

import com.codeup.blog.model.Post;
import com.codeup.blog.repos.PostRepo;
import com.codeup.blog.model.User;
import com.codeup.blog.repos.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {
    private PostRepo postDao;
    private UserRepo userDao;
    private User user = new User("example","qwerty","email@email.email");

    public PostController(PostRepo postDao) {
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
        @ModelAttribute Post post
    ) {
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/createUser")
    public String createUser(Model model) {
        model.addAttribute("nuUser",new User());
        return "posts/createUser";
    }

    @PostMapping("/posts/createUser")
    public String showCreatedUser(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "email") String email
    ) {
        User newUser = new User(username,password,email);
        userDao.save(newUser);
        return "redirect:/posts";
    }
}
