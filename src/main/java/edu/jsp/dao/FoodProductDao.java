package edu.jsp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.jsp.entity.FoodProduct;
import edu.jsp.repositry.FoodProductRepositary;

@Repository
public class FoodProductDao {
	@Autowired
	FoodProductRepositary foodprodcutrepositary;
	public FoodProduct saveFoodProduct(FoodProduct foodproduct) {
		  return foodprodcutrepositary.save(foodproduct);
	}
	
}
