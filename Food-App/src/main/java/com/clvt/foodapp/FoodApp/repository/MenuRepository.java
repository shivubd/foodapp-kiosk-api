package com.clvt.foodapp.FoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clvt.foodapp.FoodApp.dto.Menu;

public interface MenuRepository extends JpaRepository<Menu , Integer> {

}