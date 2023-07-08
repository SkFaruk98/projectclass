package edu.jsp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   @NotEmpty(message = "name can't be empty")
   @Column(unique = true)
   private String name;
   @Column(nullable= false)
   @Min(value = 10,message = "Price of Item should not be Null or more then 10 rs")
   private double price;
   @NotEmpty(message = "description can't be empty")
   private String description;
   private Type type;
   @Min(value = 1)
   private int quantity;
  
}
