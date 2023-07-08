package edu.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.config.ResponceStructure;
import edu.jsp.dto.UserDto;
import edu.jsp.entity.User;
import edu.jsp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
   private UserService userservice;
    
    @PostMapping("/save")
	public ResponseEntity<ResponceStructure<UserDto>> saveUser(@Validated @RequestBody User user) {
		return userservice.saveUser(user);
	}
    
    @GetMapping("/checkbyid")
    public ResponseEntity<ResponceStructure<UserDto>> checkUserById(@RequestParam long id) {
    	return userservice.checkUserById(id);
    }
    
    @GetMapping("/checkbynameandpassword")
    public ResponseEntity<ResponceStructure<UserDto>> checkUserbyemailandpassword(@RequestParam String email,@RequestParam String password) {
		return userservice.checkUserByemailandpassword(email, password);
	}
    
    @PostMapping("/updatePhoneNumber")
    public ResponseEntity<ResponceStructure<UserDto>> updatePhNo(@RequestParam String email, @RequestParam String password, @RequestParam long Phno) {
    	 return userservice.userPhoneUpdate(email, password, Phno);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<ResponceStructure<String>> deleteuserbyid( @RequestParam String email,@RequestParam String password,@RequestParam long id) {
    	return userservice.deleteUser(email, password, id);
    }
}
