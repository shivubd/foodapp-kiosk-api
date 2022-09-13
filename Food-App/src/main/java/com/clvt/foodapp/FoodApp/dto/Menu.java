package com.clvt.foodapp.FoodApp.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Menu {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy="menu")
	List<FoodProduct> foodProduct;
	@OneToOne
	@JoinColumn
	User user;
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<FoodProduct> getFoodProducts() {
		return foodProduct;
	}
	public void setFoodProducts(List<FoodProduct> foodProduct) {
		this.foodProduct = foodProduct;
	}

}