package com.app.admin.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.admin.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
   
	User findByName(String name);

    User findById(int id);
    
    User findByPhone(String phone);
    
    List<User> findAll();

	User findByEmail(String email);

//	User findOne(String username);

//	boolean exists(String username);
}
