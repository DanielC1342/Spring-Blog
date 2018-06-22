package com.codeup.blog;

import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post,Integer> {
 // findbytitlelike(search term)  ("%"+searchterm+"%")
}
