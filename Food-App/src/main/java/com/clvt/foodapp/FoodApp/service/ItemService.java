package com.clvt.foodapp.FoodApp.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clvt.foodapp.FoodApp.dao.ItemDao;
import com.clvt.foodapp.FoodApp.dto.Item;


@Service
public class ItemService {
	
	@Autowired
	ItemDao itemDao;
	
	public Item saveItem(Item item)
	{
		return itemDao.saveItem(item);
	}
	
	public Item updateItem(Item item)
	{
		return itemDao.updateItem(item);
		
	}
	public List<Item> getAllItems() {
		return itemDao.getAllItems();
	}

	public Item getItemById(int id) {
		return itemDao.getItemById(id);
	}

	public String deleteItem(int id) {
		return itemDao.deleteItem(id);
	}

}
