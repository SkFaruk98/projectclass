package edu.jsp.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserNotAllowedToDeleteRecordExcetion extends RuntimeException {
  private String message;

   @Override
   public String getMessage() {
	return message;
   }
}
