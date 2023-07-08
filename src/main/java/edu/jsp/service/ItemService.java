package edu.jsp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.jsp.config.ResponceStructure;
import edu.jsp.dao.ItemDao;
import edu.jsp.dao.UserDao;
import edu.jsp.entity.Item;
import edu.jsp.entity.Role;
import edu.jsp.entity.User;
import edu.jsp.exception.UserIsNotValidToEnterTheItemException;
import edu.jsp.exception.UserIsNotValidToUpdatePriceOfItemException;
import edu.jsp.exception.UserNotAllowedToDeleteRecordExcetion;

@Service
public class ItemService {
	@Autowired
	UserDao userdao;
	@Autowired
	ItemDao itemdao;
  
	public ResponseEntity<ResponceStructure<List<Item>>> saveItem(String email, String password, List<Item> item) {
	User user=userdao.finduserbyemailandpassword(email, password);
	if(user.getRole().equals(Role.ADMIN)||user.getRole().equals(Role.MANAGER)) {
		List<Item> list=new ArrayList<>();
		for(Item it:item) {
			list.add(itemdao.saveItem(it));
		}
	    ResponceStructure<List<Item>> responseStructure=new ResponceStructure<>();
	    responseStructure.setData(list);
	    responseStructure.setMessage("Items Saved");
	    responseStructure.setStatus(HttpStatus.CREATED.value());
	    
	     return new ResponseEntity<>(responseStructure,HttpStatus.CREATED);
	}
	    throw new UserIsNotValidToEnterTheItemException("user is not valid");
	}

	
	public ResponseEntity<ResponceStructure<List<Item>>> showAllItems(){
	    List<Item> item= itemdao.findAll();
	    ResponceStructure<List<Item>> responseStructure=new ResponceStructure<>();
	    responseStructure.setData(item);
	    responseStructure.setMessage("All the Items");
	    responseStructure.setStatus(HttpStatus.OK.value());
	    
	   return new ResponseEntity<>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponceStructure<Item>> finditemByname(String name) {
	   Item item=itemdao.findItemByName(name);
	   ResponceStructure<Item> responseStructure=new ResponceStructure<>();
	    responseStructure.setData(item);
	    responseStructure.setMessage("Item Found");
	    responseStructure.setStatus(HttpStatus.OK.value());
	    
	   return new ResponseEntity<>(responseStructure,HttpStatus.OK);
	}
	
	 public ResponseEntity<ResponceStructure<Item>> updateCostofItem(String email,String password,String itemname,double updatecost) {
		  User user=userdao.finduserbyemailandpassword(email, password);
		  if(user.getRole().equals(Role.ADMIN)||user.getRole().equals(Role.MANAGER)) {
			     Item item=itemdao.findItemByName(itemname);
			     item.setPrice(updatecost);
			      Item it=itemdao.saveItem(item);
			      ResponceStructure<Item> responseStructure=new ResponceStructure<>();
				    responseStructure.setData(it);
				    responseStructure.setMessage("Price of Item Update");
				    responseStructure.setStatus(HttpStatus.OK.value());
				    
				   return new ResponseEntity<>(responseStructure,HttpStatus.OK);      
		  }
		  throw new UserIsNotValidToUpdatePriceOfItemException("User not Permitted to Update Price of Item");
	 }
	 
	 public ResponseEntity<ResponceStructure<String>> deleteUser(String email,String password,String name) {
		   User user =userdao.finduserbyemailandpassword(email, password);
		   if(user.getRole().equals(Role.ADMIN)) {
			   ResponceStructure<String> responseStructure=new ResponceStructure<>();
			   responseStructure.setData(itemdao.deleteItem(name));
			   responseStructure.setMessage("Item data is deleted");
			   responseStructure.setStatus(HttpStatus.OK.value());
			   
			   return new ResponseEntity<>(responseStructure,HttpStatus.OK);
		   }
		   throw new UserNotAllowedToDeleteRecordExcetion("User is Not Permited to Destroy the Item");
		}

}









