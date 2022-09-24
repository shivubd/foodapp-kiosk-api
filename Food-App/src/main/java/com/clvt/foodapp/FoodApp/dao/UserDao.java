
package com.clvt.foodapp.FoodApp.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.clvt.foodapp.FoodApp.dto.User;
import com.clvt.foodapp.FoodApp.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
}
