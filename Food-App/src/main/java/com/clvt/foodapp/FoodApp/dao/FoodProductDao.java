package com.clvt.foodapp.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clvt.foodapp.FoodApp.dto.FoodProduct;
import com.clvt.foodapp.FoodApp.repository.FoodProductRepository;

@Repository
public class FoodProductDao {
	
	@Autowired
	FoodProductRepository foodProductRepository;
	
	public FoodProduct  saveFoodProduct(FoodProduct foodProduct) {
		return foodProductRepository.save(foodProduct);
	}

	public FoodProduct getFoodProductById(int id) {
		Optional<FoodProduct> foodProduct = foodProductRepository.findById(id);
		if(foodProduct.isPresent()) {
			return foodProduct.get();
		}throw new RuntimeException("employee is not found for the id  "+id);
	}

	public List<FoodProduct> getAllFoodProducts() {
		return foodProductRepository.findAll();
	}

	public void deleteFoodProductById(int id) {
		foodProductRepository.deleteById(id);	
	}
	public FoodProduct updateFoodProduct(FoodProduct foodProduct) {
		return foodProductRepository.save(foodProduct);
	}
}
