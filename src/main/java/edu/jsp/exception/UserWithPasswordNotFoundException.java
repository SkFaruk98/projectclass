package edu.jsp.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class UserWithPasswordNotFoundException extends RuntimeException {
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

}
