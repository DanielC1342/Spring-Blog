package com.codeup.blog.repos;

import com.codeup.blog.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post,Integer> {
 // findbytitlelike(search term)  ("%"+searchterm+"%")
}
