package com.clvt.foodapp.FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.clvt.foodapp.FoodApp.dao.UserDao;
import com.clvt.foodapp.FoodApp.dto.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}
	public String deleteUser(int id) {
		return userDao.deleteUser(id);
	}
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
}
