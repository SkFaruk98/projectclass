package edu.jsp.entity;

import java.util.List;

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
public class FoodMenu {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @OneToMany
  private List<FoodProduct> foodproduct;
  
}
