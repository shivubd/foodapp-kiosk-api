package com.clvt.foodapp.FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clvt.foodapp.FoodApp.dto.User;
import com.clvt.foodapp.FoodApp.service.UserService;

@RestController
public class FoodAppController {
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
}
