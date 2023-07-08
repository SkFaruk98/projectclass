package edu.jsp.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.entity.User;

public interface UserRepositary extends JpaRepository<User, Long>{
        
	/*This is  a custom method for this custom method we don't need to write query
	   if we want to check wither the user with given name,email,phnNo,password are present or not we us
	   this default findClassNameByAttributes custom method the starting letter of Attribute should be capital 
	   as we written the particular entity class we user And operator between two Attributes when we want to
	   find the user based on the more then one Attribute*/
	   Optional<User> findUserByEmail(String email);
	   
	   Optional<User> findUserByPassword(String password);
}
