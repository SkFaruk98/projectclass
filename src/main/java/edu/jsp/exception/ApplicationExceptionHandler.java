package edu.jsp.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.jsp.config.ResponceStructure;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
     
	
	@ExceptionHandler(UserWithEmailAndPasswordNotFoundException.class)
	public ResponseEntity<ResponceStructure<String>> handleUserWithEmailandPsswordException(UserWithEmailAndPasswordNotFoundException e) {
    	  ResponceStructure<String> responseStructure=new ResponceStructure<>();
    	  responseStructure.setData(e.getMessage());
    	  responseStructure.setMessage("User Info Not Valid");
    	  responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
    	  
    	 return new ResponseEntity<>(responseStructure,HttpStatus.NOT_FOUND);
    	  
      }
	
	@ExceptionHandler(UserByIdNotFoundException.class)
	public ResponseEntity<ResponceStructure<String>> handleUserByIdNotFoundException(UserByIdNotFoundException e) {
		ResponceStructure<String> responseStructure=new ResponceStructure<>();
		responseStructure.setData(e.getMessage());
		responseStructure.setMessage("User Info Not Valid");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(responseStructure,HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		    Map<String,String> errorMessages=new HashMap<>();
		    List<ObjectError> errors= ex.getAllErrors();
		    for(ObjectError ober:errors) {
		    	String fieldName=((FieldError)ober).getField();
		    	String errorMessage=ober.getDefaultMessage();
		    	errorMessages.put(fieldName, errorMessage);
		    }
		    ResponceStructure<Map<String,String>> responseStructure=new ResponceStructure<>();
		    responseStructure.setData(errorMessages);
		    responseStructure.setMessage("Verify the User Info");
		    responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		    
		    return new ResponseEntity<Object>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotAllowedToDeleteRecordExcetion.class)
	public ResponseEntity<ResponceStructure<String>>  handleUserNotAllowedToDeleteRecordExceptoin(UserNotAllowedToDeleteRecordExcetion ex) {
		ResponceStructure<String> responseStructure =new ResponceStructure<>();
		responseStructure.setData(ex.getMessage());
		responseStructure.setMessage("Invalid User");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserIsNotValidToAddIteamException.class)
	public ResponseEntity<ResponceStructure<String>> handleUserIsNotValidToAddItemException(UserIsNotValidToAddIteamException ex) {
		   ResponceStructure<String> responseStructure = new ResponceStructure<>();
		   responseStructure.setData(ex.getMessage());
		   responseStructure.setMessage("User is Not valid");
		   responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		   
		  return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
   
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponceStructure<List<String>>> handleConstraintViolationException(ConstraintViolationException es) {
		   
		  List<String> message=new ArrayList<>();
		   Set<ConstraintViolation<?>> object=es.getConstraintViolations();
		   for(ConstraintViolation<?> cons:object) {
			   message.add(cons.getMessageTemplate());
		   }
		   ResponceStructure<List<String>> responseStructure = new ResponceStructure<>();
		   responseStructure.setData(message);
		   responseStructure.setMessage("Verify the Item Info");
		   responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());   
		   
		  return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponceStructure<String>> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException ex) {
		 ResponceStructure<String> responseStructure = new ResponceStructure<>();
		   responseStructure.setData(ex.getLocalizedMessage());
		   responseStructure.setMessage("Enter the Unique Item");
		   responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());   
		   return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ItemByNameNotFoundException.class)
	public ResponseEntity<ResponceStructure<String>> handleItemByNameNotFoundException(ItemByNameNotFoundException e) {
		ResponceStructure<String> responseStructure=new ResponceStructure<>();
		responseStructure.setData(e.getMessage());
		responseStructure.setMessage("Item Info Not Valid");
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserIsNotValidToUpdatePriceOfItemException.class)
	public ResponseEntity<ResponceStructure<String>> handleItemByNameNotFoundException(UserIsNotValidToUpdatePriceOfItemException e) {
		ResponceStructure<String> responseStructure=new ResponceStructure<>();
		responseStructure.setData(e.getMessage());
		responseStructure.setMessage("User is Not Valid");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserIsNotValidToAddFoodProductException.class)
	public ResponseEntity<ResponceStructure<String>> handleItemByNameNotFoundException(UserIsNotValidToAddFoodProductException e) {
		ResponceStructure<String> responseStructure=new ResponceStructure<>();
		responseStructure.setData(e.getMessage());
		responseStructure.setMessage("User is Not Valid");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserWithPasswordNotFoundException.class)
	public ResponseEntity<ResponceStructure<String>> handleUserWithPasswordNotFoundException(UserWithPasswordNotFoundException e) {
		ResponceStructure<String> responseStructure=new ResponceStructure<>();
		responseStructure.setData(e.getMessage());
		responseStructure.setMessage("User not Found");
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
	}


}
