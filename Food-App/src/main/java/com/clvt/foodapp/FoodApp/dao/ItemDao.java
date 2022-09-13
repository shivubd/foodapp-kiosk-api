package com.clvt.foodapp.FoodApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clvt.foodapp.FoodApp.dto.Item;
import com.clvt.foodapp.FoodApp.repository.ItemRepository;

@Repository
public class ItemDao {
	
	@Autowired
	ItemRepository itemRepository;
	
	public Item saveItem(Item item)
	{
		return itemRepository.save(item);
	}
	
	public Item updateItem(Item item)
	{
		return itemRepository.save(item);
	}
	

}
