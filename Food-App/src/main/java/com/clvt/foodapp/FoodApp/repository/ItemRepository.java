

package com.clvt.foodapp.FoodApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clvt.foodapp.FoodApp.dto.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}