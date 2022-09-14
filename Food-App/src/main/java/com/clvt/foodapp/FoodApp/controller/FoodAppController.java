package com.clvt.foodapp.FoodApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clvt.foodapp.FoodApp.dto.Item;
import com.clvt.foodapp.FoodApp.service.ItemService;


@RestController
public class FoodAppController {
	
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
}
