package edu.jsp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.entity.FoodProduct;

public interface FoodProductRepositary extends  JpaRepository<FoodProduct, Long>{

}
