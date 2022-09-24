
package com.clvt.foodapp.FoodApp.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clvt.foodapp.FoodApp.dao.FoodOrderDao;
import com.clvt.foodapp.FoodApp.dto.FoodOrder;
import com.clvt.foodapp.FoodApp.dto.Item;
@Component
public class FoodOrderService {
	@Autowired
	FoodOrderDao foodOrderDao;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderDao.saveFoodOrder(foodOrder);
	}
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return foodOrderDao.updateFoodOrder(foodOrder);
	}
	public FoodOrder getFoodOrderById(int id) {
		return foodOrderDao.getFoodOrderById(id);
	}
	public List<FoodOrder> getOrders(){
		return foodOrderDao.getOrders();
	}
	public String deleteFoodOrderById(int id) {
		return foodOrderDao.deleteFoodOrderById(id);
	}
	
	@Autowired
	FoodProductService fp;
	public void sendMail(FoodOrder foodOrder) throws AddressException, MessagingException, IOException {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("shivarajdeyannavar@gmail.com", "lqomgobdvlnnrpmk");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("noreply@gmail.com", false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(foodOrder.getContactNumber()));
		   msg.setSubject("ORDER SUMMARY");
		   String content = "OrderId: "+foodOrder.getId()+"\nCustomer name: "+foodOrder.getCustomerName()+"\n\n\n"
		   		+ "ITEMS\n";
		   for(Item i:foodOrder.getItems()) {
			   content = content + "\n" + fp.getFoodProductById(i.getProductId()).getName() + "--" + i.getQuantity() + ".Nos--Rs." + i.getPrice();
		   }
		   content = content + "\n\n\nTOTAL : Rs." + foodOrder.getTotalPrice();
		   content = content + "\n\n\n\n\n"+"Ordred at: \n"+ foodOrder.getOrderCreatedTime();
		   content = content + "\n\n"+"Order recieved: \n" + foodOrder.getOrderDeliveryTime();
		   System.out.println(content);
		   msg.setContent(content, "text/plain");
		   msg.setSentDate(new Date());
		   Transport.send(msg);
	}
}
