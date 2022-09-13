package com.clvt.foodapp.FoodApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clvt.foodapp.FoodApp.dto.FoodProduct;


@Repository
public interface FoodProductRepository extends JpaRepository<FoodProduct, Integer> {

	
	
}
