package com.clvt.foodapp.FoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clvt.foodapp.FoodApp.dto.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {

}