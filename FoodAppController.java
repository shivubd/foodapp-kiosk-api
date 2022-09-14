package com.clvt.foodapp.FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clvt.foodapp.FoodApp.dto.FoodProduct;
import com.clvt.foodapp.FoodApp.dto.Menu;
import com.clvt.foodapp.FoodApp.service.FoodProductService;
import com.clvt.foodapp.FoodApp.service.MenuService;

import java.util.List;

@RestController
public class FoodAppController{
	
	
	//foodProduct
	@Autowired
	FoodProductService foodProductService;
	

	
	@PostMapping("/foodProducts")
	public FoodProduct saveFoodProduct(@RequestBody FoodProduct foodProduct) {
		return foodProductService.saveFoodProduct(foodProduct);
	}
	
	@GetMapping("/foodProducts/{id}")
	public FoodProduct getFoodProductById(@PathVariable int id) {
		return foodProductService.getFoodProductById(id);
	}
	@GetMapping("/foodProducts")
	public List<FoodProduct> getAllFoodProduct() {
		return foodProductService.getAllFoodProduct();
	}
	
	@DeleteMapping("/foodProducts/{id}")
	public void deleteFoodProductById(@PathVariable int id) {
		 foodProductService.deleteFoodProductById(id);
	}
	
	@PutMapping("/foodProducts/{id}")
	public FoodProduct updateFoodProduct(@RequestBody FoodProduct foodProduct,@PathVariable int id) {
		return foodProductService.updateFoodProduct(foodProduct,id);
	}
	
	
	
	//menu

	@Autowired
	 MenuService menuService;
	@PostMapping("/menu")
	public Menu saveMenu(@RequestBody Menu menu) {
		return menuService.saveMenu(menu);
	}
	
	@GetMapping("/menu/{id}")
	public Menu getMenuById(@PathVariable int id) {
		return menuService.getMenuById(id);
	}
	@GetMapping("/menu")
	public List<Menu> getAllMenu() {
		return menuService.getAllMenu();
	}
	
	@DeleteMapping("/menu/{id}")
	public void deleteMenuById(@PathVariable int id) {
		 menuService.deleteMenuById(id);
	}
	
	@PutMapping("/menu/{id}")
	public Menu updateMenu(@RequestBody Menu menu,@PathVariable int id) {
		return menuService.updateMenu(menu,id);
	}

	
	
}
	
