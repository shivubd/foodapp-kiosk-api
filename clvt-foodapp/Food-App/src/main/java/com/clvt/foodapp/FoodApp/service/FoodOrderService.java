package com.clvt.foodapp.FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clvt.foodapp.FoodApp.dao.FoodOrderDao;
import com.clvt.foodapp.FoodApp.dto.FoodOrder;
@Component
public class FoodOrderService {
	@Autowired
	FoodOrderDao foodOrderDao;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderDao.saveFoodOrder(foodOrder);
	}
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return foodOrderDao.updateFoodOrder(foodOrder);
	}
	public FoodOrder getFoodOrderById(int id) {
		return foodOrderDao.getFoodOrderById(id);
	}
	public String deleteFoodOrderById(int id) {
		return foodOrderDao.deleteFoodOrderById(id);
	}
}
