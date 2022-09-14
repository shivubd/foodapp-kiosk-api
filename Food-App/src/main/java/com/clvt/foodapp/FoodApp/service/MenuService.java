package com.clvt.foodapp.FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clvt.foodapp.FoodApp.dao.MenuDao;
import com.clvt.foodapp.FoodApp.dto.Menu;


@Service
public class MenuService {
	@Autowired
	MenuDao menuDao;
	
	
	public Menu saveMenu(Menu menu) {
		return menuDao.saveMenu(menu);
	}


	public Menu getMenuById(int id) {
		return menuDao.getMenuById(id);
	}


	public List<Menu> getAllMenu() {
		return menuDao.getAllMenus();
	}


	public void  deleteMenuById(int id) {
		menuDao.deleteMenuById(id);
	}


	public  Menu updateMenu(Menu menu, int id) {
		// TODO Auto-generated method stub
		return menuDao.updateMenu(menu,id);
	}

	
	

}
