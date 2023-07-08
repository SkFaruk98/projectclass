package edu.jsp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.jsp.entity.User;
import edu.jsp.exception.UserByIdNotFoundException;
import edu.jsp.exception.UserWithEmailAndPasswordNotFoundException;
import edu.jsp.exception.UserWithPasswordNotFoundException;
import edu.jsp.repositry.UserRepositary;

@Repository
public class UserDao {
	@Autowired
	UserRepositary userepositary;
	
   public User saveUser(User user) {
	   return userepositary.save(user);
   }
   
   public User findUserById(long id) {
	   Optional<User> user=userepositary.findById(id);
	   if(user.isPresent()) {
		   return user.get();
	   }
	   throw new UserByIdNotFoundException("User with given id not found");
   }
   
   public User finduserbyemailandpassword(String email,String password) {              
	Optional<User> mail =userepositary.findUserByEmail(email);
	Optional<User>  word =userepositary.findUserByPassword(password);
	if(mail.isPresent()&&word.isPresent()) 
		return word.get();
	else if(mail.isPresent()&&word.isEmpty()) {
		throw new UserWithPasswordNotFoundException("Incorrect Password");
	}
	else
		throw new UserWithEmailAndPasswordNotFoundException("User with Email and Password is not found");
	   
   }
   
   public String  deleteUser( long id) {
	   if(findUserById(id)!=null) {
	   userepositary.delete(findUserById(id)); 
	   return "User deleted";
	   }
	   else throw new UserByIdNotFoundException("User with given id not found");
   }
   
   public User updatePhonenNo(String email,String password,long phnNo) {
	         User user=finduserbyemailandpassword(email, password);
	         user.setPhnNo(phnNo);
	         return saveUser(user);
   }
   
}
