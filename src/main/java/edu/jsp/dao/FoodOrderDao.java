package edu.jsp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.jsp.entity.FoodOrder;
import edu.jsp.repositry.FoodOrderRepositary;

@Repository
public class FoodOrderDao {
     @Autowired
     FoodOrderRepositary foodorderrepositary;
     
     public FoodOrder saveFoodOrder(FoodOrder foodorder) {
    	 return foodorderrepositary.save(foodorder);
     }
     
}
