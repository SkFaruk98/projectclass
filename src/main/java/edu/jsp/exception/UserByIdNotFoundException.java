package edu.jsp.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserByIdNotFoundException extends RuntimeException {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

}
