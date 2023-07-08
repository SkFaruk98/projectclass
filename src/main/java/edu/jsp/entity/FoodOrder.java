package edu.jsp.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class FoodOrder {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private Status foodstatus;
   @CreationTimestamp
   private LocalDateTime foodOrdered;
   private LocalDateTime foodDelivered;
   private double totalPrice;
   @OneToMany
   private List<FoodProduct> foodproducts;
   
   
   
}
