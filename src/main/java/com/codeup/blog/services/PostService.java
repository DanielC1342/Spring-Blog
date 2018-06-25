//package com.codeup.blog;
//
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class PostService {
//    private List<Post> list;
//
//    public PostService() {
//        list = new ArrayList<>();
//        addPosts();
//    }
//
//    public void save(Post nu) {
//        int id = list.size() + 1;
//        nu.setId(id);
//        list.add(nu);
//    }
//
//    public void addPosts() {
//        Post postA = new Post(1,"Post A", "Here is the body of post A");
//        Post postB = new Post(2,"Post B", "Here is the body of post B");
//        Post postC = new Post(3,"Post C", "Here is the body of post C");
//        list.add(postA);
//        list.add(postB);
//        list.add(postC);
//    }
//
//    public Post find(int id) {
//        for(Post iter : list) {
//            if(iter.getId() == id) {
//                return iter;
//            }
//        }
//        return null;
//    }
//
//    public List<Post> all() {
//        return list;
//    }
//}
