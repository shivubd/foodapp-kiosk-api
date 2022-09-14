package com.clvt.foodapp.FoodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clvt.foodapp.FoodApp.dto.FoodOrder;
import com.clvt.foodapp.FoodApp.dto.Item;
import com.clvt.foodapp.FoodApp.dto.User;
import com.clvt.foodapp.FoodApp.service.FoodOrderService;
import com.clvt.foodapp.FoodApp.service.ItemService;
import com.clvt.foodapp.FoodApp.service.UserService;


@RestController
public class FoodAppController {
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	@GetMapping("/user")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	@DeleteMapping("/user")
	public String deleteUserById(@RequestParam int id) {
		return userService.deleteUser(id);
	}
	
	@Autowired
	ItemService itemService;
	
	@PostMapping("/items")
	public Item saveCar(@RequestBody Item item)
	{
		return itemService.saveItem(item);
	}
	
	@PutMapping("/items")
	public Item updateItem(@RequestBody Item item)
	{
		return itemService.updateItem(item);
	}
	
	@GetMapping("/items")
	public List<Item> getAllItems()
	{
		return itemService.getAllItems();
	}
	
	@GetMapping("/items/{id}")
    public Item getItemById(@PathVariable int id) {
        return itemService.getItemById(id);
    }



   @DeleteMapping("/items/{id}")
    public String deleteCar(@PathVariable int id) {
        return itemService.deleteItem(id);
}
	
	
	@Autowired
	FoodOrderService foodOrderService;
	@PostMapping("/order")
	public FoodOrder saveOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.saveFoodOrder(foodOrder);
	}
	@PutMapping("/order")
	public FoodOrder updateOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.updateFoodOrder(foodOrder);
	}
	@GetMapping("/order")
	public List<FoodOrder> getOrders(){
		return foodOrderService.getOrders();
	}
	@GetMapping("/order/{id}")
	public FoodOrder getOrderById(@PathVariable int id) {
		return foodOrderService.getFoodOrderById(id);
	}
	@DeleteMapping("/order")
	public String deleteOrderById(@RequestParam int id) {
		return foodOrderService.deleteFoodOrderById(id);
	}
}

