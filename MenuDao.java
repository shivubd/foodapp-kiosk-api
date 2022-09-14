package com.clvt.foodapp.FoodApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clvt.foodapp.FoodApp.dto.Menu;
import com.clvt.foodapp.FoodApp.repository.MenuRepository;


@Repository
public class MenuDao {
	
	
	
	@Autowired
	
	MenuRepository menuRepository;
	
	public Menu  saveMenu(Menu menu) {
		return menuRepository.save(menu);
	}

	public Menu getMenuById(int id) {
		Optional<Menu> menu = menuRepository.findById(id);
		if(menu.isPresent()) {
			return menu.get();
		}throw new RuntimeException("employee is not found for the id  "+id);
	}

	public List<Menu> getAllMenus() {
		return menuRepository.findAll();
	}

	public void deleteMenuById(int id) {
		menuRepository.deleteById(id);	
	}

	public Menu updateMenu(Menu menu, int id) {
		Optional<Menu> current =menuRepository.findById(id);
		if(current.isPresent()) {
			menu.setId(id);
			return menuRepository.save(menu);
		}else {
			return null;
		}
}


}
