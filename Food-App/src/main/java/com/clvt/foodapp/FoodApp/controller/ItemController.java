package com.clvt.foodapp.FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clvt.foodapp.FoodApp.dto.Item;
import com.clvt.foodapp.FoodApp.service.ItemService;

@RestController
public class ItemController {
	
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
}
