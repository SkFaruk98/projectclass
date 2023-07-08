package edu.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.jsp.config.ResponceStructure;
import edu.jsp.dao.UserDao;
import edu.jsp.dto.UserDto;
import edu.jsp.entity.Role;
import edu.jsp.entity.User;
import edu.jsp.exception.UserNotAllowedToDeleteRecordExcetion;

@Service
public class UserService {
    @Autowired
	private UserDao userdao;
    
	public ResponseEntity<ResponceStructure<UserDto>> saveUser(User user) {
		ResponceStructure<UserDto> responcestructure=new ResponceStructure<>();
		responcestructure.setData(mapfromEntityusertouserDto(userdao.saveUser(user)));
		responcestructure.setMessage("saved");
		responcestructure.setStatus(HttpStatus.CREATED.value());
		  ResponseEntity<ResponceStructure<UserDto>> responseentity=new ResponseEntity(responcestructure,HttpStatus.CREATED);
		  return responseentity;
	}

	private UserDto mapfromEntityusertouserDto(User users) {
		return new UserDto(users.getId(),users.getName(),users.getEmail(),users.getPhnNo(),users.getRole());
	}
	
	  
		public ResponseEntity<ResponceStructure<UserDto>> checkUserByemailandpassword(String email,String password) {
			ResponceStructure<UserDto> responcestructure=new ResponceStructure<>();
			responcestructure.setData(mapfromEntityusertouserDto(userdao.finduserbyemailandpassword(email, password)));
			responcestructure.setMessage("User found");
			responcestructure.setStatus(HttpStatus.OK.value());
			  ResponseEntity<ResponceStructure<UserDto>> responseentity=new ResponseEntity(responcestructure,HttpStatus.OK);
			  return responseentity;
		}
		
		public ResponseEntity<ResponceStructure<UserDto>> checkUserById(long id) {
			ResponceStructure<UserDto> responcestructure=new ResponceStructure<>();
			responcestructure.setData(mapfromEntityusertouserDto(userdao.findUserById(id)));
			responcestructure.setMessage("User found");
			responcestructure.setStatus(HttpStatus.OK.value());
			  ResponseEntity<ResponceStructure<UserDto>> responseentity=new ResponseEntity(responcestructure,HttpStatus.OK);
			  return responseentity;
		}
		
		public ResponseEntity<ResponceStructure<String>> deleteUser(String email,String password,long id) {
		   User user =userdao.finduserbyemailandpassword(email, password);
		   if(user.getRole().equals(Role.ADMIN)) {
			   ResponceStructure<String> responseStructure=new ResponceStructure<>();
			   responseStructure.setData(userdao.deleteUser(id));
			   responseStructure.setMessage("User data is deleted");
			   responseStructure.setStatus(HttpStatus.OK.value());
			   
			   return new ResponseEntity<>(responseStructure,HttpStatus.OK);
		   }
		   throw new UserNotAllowedToDeleteRecordExcetion("User is Not Permited to Destroy the Data");
		}
	    
		public ResponseEntity<ResponceStructure<UserDto>> userPhoneUpdate(String email,String password,long phno) {
			       User user =userdao.updatePhonenNo(email, password,phno);
				   ResponceStructure<UserDto> responseStructure=new ResponceStructure<>();
				   responseStructure.setData(mapfromEntityusertouserDto(user));
				   responseStructure.setMessage("User Phone Number is Updated");
				   responseStructure.setStatus(HttpStatus.OK.value());
				   return new ResponseEntity<>(responseStructure,HttpStatus.OK);
			}
} 
