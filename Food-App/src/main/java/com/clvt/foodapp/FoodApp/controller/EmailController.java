package com.clvt.foodapp.FoodApp.controller;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clvt.foodapp.FoodApp.dto.Password;
import com.clvt.foodapp.FoodApp.dto.User;
import com.clvt.foodapp.FoodApp.dto.VerificationCode;
import com.clvt.foodapp.FoodApp.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmailController {

	@Autowired
	UserRepository userRepository;
	public int verification_code;
	public String userEmail;

	@GetMapping(value = "/sendemail")
	public boolean sendEmail(@RequestParam String email) throws AddressException, MessagingException, IOException {

		Optional<User> current = userRepository.findByEmail(email);
		if (current.isPresent()) {
			userEmail = email;
			
			sendmail(email);
			return true;
		} else {
			return false;
		}
	}

	@PostMapping(value = "/verify")
	public boolean verify(@RequestBody VerificationCode vcode)
			throws AddressException, MessagingException, IOException {

		if (verify(vcode.getVcode())) {
			return true;
		} else {
			return false;
		}

	}

	@PostMapping(value = "/setPass")
	public void Setpass(@RequestBody Password password) throws AddressException, MessagingException, IOException {

		System.out.println(password.getPass());
		Optional<User> current = userRepository.findByEmail(userEmail);
		User newPassForUser = current.get();
		System.out.println("\n\n \n " +password.getPass());
		newPassForUser.setPassword(password.getPass());
		System.out.println("\n\n \n " +newPassForUser.getPassword());
		userRepository.save(newPassForUser);

	}

	private void sendmail(String email) throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("anandache.laxmi96@gmail.com", "sukxrpaxykkqdbyb");
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("projectcatheter@gmail.com", false));

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
		msg.setSubject("Reset Password for FoodApp");

		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();

		verification_code = Math.abs(email.hashCode());

		messageBodyPart.setContent(
				"Reset password using the given link http://localhost:4200/verify \n enter the verification code  -->"
						+ verification_code,
				"text/plain");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		msg.setContent(multipart);
		
		System.out.println("sending email");
		Transport.send(msg);
	}
	public boolean verify(int code) {
		System.out.println(verification_code);
		if (code == verification_code) {
			return true;
		} else {
			return false;
		}

	}
}