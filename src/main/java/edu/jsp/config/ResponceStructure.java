package edu.jsp.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponceStructure<T> {
   private int status;
   private String message;
   private T data;
   
   
}
