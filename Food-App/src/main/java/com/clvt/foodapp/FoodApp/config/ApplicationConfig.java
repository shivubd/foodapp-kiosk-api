package com.clvt.foodapp.FoodApp.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class ApplicationConfig {
	@Bean
    public Docket getDocket() {
        
        Contact contact = new Contact("clarivate Global Team", "https://clarivateglobal.com/","test@clarivateglobal.com");

       @SuppressWarnings("rawtypes")
        List<VendorExtension> vendorExtensions = new ArrayList<>();
       
       ApiInfo apiInfo = new ApiInfo("FoodApp RESTful Web Service documentation",
                "This has list all the end points for clarivateglobal FoodApp application", "1.0",
                "https://clarivateglobal.com/services/software-development/", contact, "Apache 2.0",
                "https://clarivateglobal.com/services/software-development/", vendorExtensions);
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.clvt.foodapp.FoodApp")).build().apiInfo(apiInfo)
                .useDefaultResponseMessages(false);
    }
//	@Bean
//	public JavaMailSender getJavaMailSender() {
//	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//	    mailSender.setHost("smtp.gmail.com");
//	    mailSender.setPort(587);
//	    
//	    mailSender.setUsername("my.gmail@gmail.com");
//	    mailSender.setPassword("password");
//	    
//	    Properties props = mailSender.getJavaMailProperties();
//	    props.put("mail.transport.protocol", "smtp");
//	    props.put("mail.smtp.auth", "true");
//	    props.put("mail.smtp.starttls.enable", "true");
//	    props.put("mail.debug", "true");
//	    
//	    return mailSender;
//	}
}
