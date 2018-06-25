package com.codeup.blog.repos;

import com.codeup.blog.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer> {

}
