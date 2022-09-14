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

	@OneToMany
	List<FoodProduct> foodProduct;

	@OneToMany(mappedBy="menu")
	List<FoodProduct> foodProducts;

	@OneToOne
	@JoinColumn
	User user;
	



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public void setFoodProduct(List<FoodProduct> foodProduct) {
		this.foodProduct = foodProduct;
	}
	public List<FoodProduct> getFoodProduct() {
		return foodProduct;
	}
	public void setFoodProducts(List<FoodProduct> foodProducts) {
		this.foodProduct = foodProducts;
	}

}

	

