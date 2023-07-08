package edu.jsp.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.entity.FoodOrder;

public interface FoodOrderRepositary  extends JpaRepository<FoodOrder, Long>{

}
