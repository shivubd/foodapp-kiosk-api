package com.clvt.foodapp.FoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clvt.foodapp.FoodApp.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
