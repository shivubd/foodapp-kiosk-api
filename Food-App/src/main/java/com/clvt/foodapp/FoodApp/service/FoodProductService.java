package com.clvt.foodapp.FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.clvt.foodapp.FoodApp.dao.FoodProductDao;

import com.clvt.foodapp.FoodApp.dto.FoodProduct;
import java.util.List;

@Service
public class FoodProductService {
	
	@Autowired
	FoodProductDao foodProductDao;
	
	
	public FoodProduct saveFoodProduct(FoodProduct foodProduct) {
		return foodProductDao.saveFoodProduct(foodProduct);
	}


	public FoodProduct getFoodProductById(int id) {
		return foodProductDao.getFoodProductById(id);
	}


	public List<FoodProduct> getAllFoodProduct() {
		return foodProductDao.getAllFoodProducts();
	}


	public void  deleteFoodProductById(int id) {
		 foodProductDao.deleteFoodProductById(id);
	}


	public FoodProduct updateFoodProduct(FoodProduct foodProduct) {
		return foodProductDao.updateFoodProduct(foodProduct);
	}

}
