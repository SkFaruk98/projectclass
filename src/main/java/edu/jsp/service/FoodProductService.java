package edu.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.jsp.config.ResponceStructure;
import edu.jsp.dao.FoodProductDao;
import edu.jsp.dao.UserDao;
import edu.jsp.entity.FoodProduct;
import edu.jsp.entity.Role;
import edu.jsp.entity.User;
import edu.jsp.exception.UserIsNotValidToAddFoodProductException;

@Service
public class FoodProductService {
	@Autowired
    UserDao userdao;
	@Autowired
    FoodProductDao foodproductdao;
	
	 public ResponseEntity<ResponceStructure<FoodProduct>> saveFoodProduct(String email,String password,FoodProduct foodproduct) {
		  User user=userdao.finduserbyemailandpassword(email, password);
		  if(user.getRole().equals(Role.ADMIN)||user.getRole().equals(Role.MANAGER)) {
			      ResponceStructure<FoodProduct> responseStructure=new ResponceStructure<>();
				    responseStructure.setData(foodproductdao.saveFoodProduct(foodproduct));
				    responseStructure.setMessage("foodproduct saved ");
				    responseStructure.setStatus(HttpStatus.CREATED.value());
				    
				   return new ResponseEntity<>(responseStructure,HttpStatus.CREATED);      
		  }
		  throw new UserIsNotValidToAddFoodProductException("User not Permitted to Add FoodProduct");
	 }
}
