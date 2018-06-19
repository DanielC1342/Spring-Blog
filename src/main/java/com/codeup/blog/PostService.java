package com.codeup.blog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private List<Post> list;

    public PostService() {
        list = new ArrayList<>();
        addPosts();
    }

    public void addPosts() {
        Post postA = new Post("Post A", "Here is the body of post A");
        Post postB = new Post("Post B", "Here is the body of post B");
        Post postC = new Post("Post C", "Here is the body of post C");
        list.add(postA);
        list.add(postB);
        list.add(postC);
    }

    public Post find(int id) {
        return list.get(0);
    }

    public List<Post> all() {
        return list;
    }
}
