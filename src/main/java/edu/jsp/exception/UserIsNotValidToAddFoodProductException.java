package edu.jsp.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserIsNotValidToAddFoodProductException extends RuntimeException {
  private String message;
  
   @Override
	public String getMessage() {
		return message;
	}
}
