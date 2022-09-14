package com.clvt.foodapp.FoodApp.dao;


import java.util.List;
import java.util.Optional;

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
	
	public List<Item> getAllItems()
	{
		return itemRepository.findAll();
	}
	
	public Item getItemById(int id)
	{
		Optional<Item> found = itemRepository.findById(id);
		if(found.isPresent())
		{
			return found.get();
			
		}else
		{
			return null;
		}
	}
	
	
	
	 public String deleteItem(int id)
	    {
	        Item item = getItemById(id);
	        if(item != null)
	        {
	            itemRepository.delete(item);
	            return item.getName()+" Item is deleted";
	        }else {
	            return "No Item is available with specified id";
	        }
	    }
	
	
	

}
