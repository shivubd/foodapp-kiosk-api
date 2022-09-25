package com.clvt.foodapp.FoodApp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.clvt.foodapp.FoodApp.dto.User;

public interface UserRepository extends JpaRepository<User, String> {
	 public Optional<User> findByEmail(String email);
}