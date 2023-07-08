package edu.jsp.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ItemByIdNotFoundException extends RuntimeException {
     private String message;

	public String getMessage() {
		return message;
	}
     
}
