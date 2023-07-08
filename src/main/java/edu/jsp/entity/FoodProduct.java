package edu.jsp.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class FoodProduct {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String name;
   private double total_Prize;
   private double discount;
   private String availability;
   private Type type;
   @OneToMany
   List<Item> Items;
  
}
