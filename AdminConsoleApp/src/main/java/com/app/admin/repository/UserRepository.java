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

	//@Query("SELECT e FROM Employee e WHERE e.name LIKE %?1%")
	 //List<User> findByName2(String name);
	
	List<User> findByNameContaining(String name);
	
	List<User> findByIdIn(int id);
	
//	User findOne(String username);

//	boolean exists(String username);
}
