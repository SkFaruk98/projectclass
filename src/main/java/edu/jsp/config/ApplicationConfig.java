package edu.jsp.config;



import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
public class ApplicationConfig {
  
  @Bean
  public OpenAPI swaggerDocOpenApi() {
	  
	Server developmentServer =new Server();
	developmentServer.setUrl("http://localhost:8080");
	developmentServer.setDescription("This Url is for Development");
	
	Server prodcutionServer =new Server();
	prodcutionServer.setUrl("http://localhost:8080");
	prodcutionServer.setDescription("This Url is for Production");
	
	Contact contact = new Contact();
	contact.setName("FoodApp");
	contact.setEmail("rusto.www.in");
	contact.setUrl("www.ruto.com");
	
	License license = new License();
	license.name("MIT License");
	license.url("Coming Soon");
	
	Info info = new Info();
	info.title("Rusto FoodApp RestApi's");
	info.contact(contact);
	info.license(license);
	info.version("1.0.0");
	info.description("This FoodApp is designed to reduce Manual Work");
	info.termsOfService("www.foodapp.in/terms");
	
	OpenAPI openApi=new OpenAPI();
	openApi.info(info);
	openApi.servers(Arrays.asList(developmentServer,prodcutionServer));
	
	return openApi;

  }
}
