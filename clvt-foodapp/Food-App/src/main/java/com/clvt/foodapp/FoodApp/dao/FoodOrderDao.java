package com.clvt.foodapp.FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clvt.foodapp.FoodApp.dto.FoodOrder;
import com.clvt.foodapp.FoodApp.repository.FoodOrderRepository;
@Component
public class FoodOrderDao {
	@Autowired
	FoodOrderRepository foodOrderRepository;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}
	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> foodOrder = foodOrderRepository.findById(id);
		if(foodOrder.isPresent()) {
			return foodOrder.get();
		}
		else {
			return null;
		}
	}
	public String deleteFoodOrderById(int id) {
		FoodOrder foodOrder = getFoodOrderById(id);
		if(foodOrder!=null) {
			foodOrderRepository.delete(foodOrder);
			return foodOrder.getId()+" "+foodOrder.getCustomerName()+" order is deleted sucessfully";
		}
		else {
			return "No Food Order Found";
		}
	}
}
