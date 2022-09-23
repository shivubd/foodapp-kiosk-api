package com.clvt.foodapp.FoodApp.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clvt.foodapp.FoodApp.dto.FoodOrder;
import com.clvt.foodapp.FoodApp.dto.FoodProduct;
import com.clvt.foodapp.FoodApp.dto.Item;
import com.clvt.foodapp.FoodApp.dto.Menu;
import com.clvt.foodapp.FoodApp.dto.User;
import com.clvt.foodapp.FoodApp.service.FoodOrderService;
import com.clvt.foodapp.FoodApp.service.FoodProductService;
import com.clvt.foodapp.FoodApp.service.MenuService;
import com.clvt.foodapp.FoodApp.service.UserService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FoodAppController {
	@Autowired
	UserService userService;
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "User added sucessfully")})
	@PostMapping(value =  "/user",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "User updated sucessfully")})
	@PutMapping(value = "/user",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Users fetched sucessfully")})
	@GetMapping(value = "/user",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "User with specified id fetched sucessfully")})
	@GetMapping(value = "/user/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "User with specified id deleted sucessfully")})
	@DeleteMapping(value = "/user",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public String deleteUserById(@RequestParam int id) {
		return userService.deleteUser(id);
	}
	
	
	
	@Autowired
	FoodOrderService foodOrderService;
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Order added sucessfully")})
	@PostMapping(value = "/order",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public FoodOrder saveOrder(@RequestBody FoodOrder foodOrder) {
		for(Item item: foodOrder.getItems()) {
			FoodProduct foodProduct =  foodProductService.getFoodProductById(item.getProductId());
			foodProduct.reduceAvailability(item.getQuantity());
			foodProductService.updateFoodProduct(foodProduct);
		}
		try {
			this.foodOrderService.sendMail(foodOrder);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return foodOrderService.saveFoodOrder(foodOrder);
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Order updated sucessfully")})
	@PutMapping(value = "/order",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public FoodOrder updateOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.updateFoodOrder(foodOrder);
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Orders fetched sucessfully")})
	@GetMapping(value = "/order",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<FoodOrder> getOrders(){
		return foodOrderService.getOrders();
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Order with specified id was fetched sucessfully")})
	@GetMapping(value = "/order/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public FoodOrder getOrderById(@PathVariable int id) {
		return foodOrderService.getFoodOrderById(id);
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Order with specified id was deleted sucessfully")})
	@DeleteMapping(value = "/order",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public String deleteOrderById(@RequestParam int id) {
		return foodOrderService.deleteFoodOrderById(id);
	}


	@Autowired
	FoodProductService foodProductService;
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Food Product was added sucessfully")})
	@PostMapping(value = "/foodProducts",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public FoodProduct saveFoodProduct(@RequestBody FoodProduct foodProduct) {
		return foodProductService.saveFoodProduct(foodProduct);
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Food Products were fetched sucessfully")})
	@GetMapping(value = "/foodProducts/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public FoodProduct getFoodProductById(@PathVariable int id) {
		return foodProductService.getFoodProductById(id);
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Food Product with specified id was fetched sucessfully")})
	@GetMapping(value = "/foodProducts",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<FoodProduct> getAllFoodProduct() {
		return foodProductService.getAllFoodProduct();
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Food Product with specified id was deleted sucessfully")})
	@DeleteMapping(value = "/foodProducts/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public void deleteFoodProductById(@PathVariable int id) {
		 foodProductService.deleteFoodProductById(id);
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Food Product was updated sucessfully")})
	@PutMapping(value = "/foodProducts",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public FoodProduct updateFoodProduct(@RequestBody FoodProduct foodProduct) {
		return foodProductService.updateFoodProduct(foodProduct);
	}
	

	@Autowired
	 MenuService menuService;
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Menu was updated sucessfully")})
	@PostMapping(value = "/menu",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Menu saveMenu(@RequestBody Menu menu) {
		return menuService.saveMenu(menu);
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Menu with specified id was fetched sucessfully")})
	@GetMapping(value = "/menu/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Menu getMenuById(@PathVariable int id) {
		return menuService.getMenuById(id);
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Menus fetched sucessfully")})
	@GetMapping(value = "/menu",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Menu> getAllMenu() {
		return menuService.getAllMenu();
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Menu was deleted sucessfully")})
	@DeleteMapping(value = "/menu/{id}",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public void deleteMenuById(@PathVariable int id) {
		 menuService.deleteMenuById(id);
	}
	
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Menu with specified id was updated sucessfully")})
	@PutMapping(value = "/menu",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public Menu updateMenu(@RequestBody Menu menu) {
		return menuService.updateMenu(menu);
	}
}

