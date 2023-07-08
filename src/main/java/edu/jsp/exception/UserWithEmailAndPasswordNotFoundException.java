package edu.jsp.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserWithEmailAndPasswordNotFoundException extends RuntimeException {
    private String message;

	public String getMessage() {
		return message;
	}
    
    
	
}
