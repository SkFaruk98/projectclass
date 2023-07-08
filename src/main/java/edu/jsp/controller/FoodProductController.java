package edu.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.config.ResponceStructure;
import edu.jsp.entity.FoodProduct;
import edu.jsp.service.FoodProductService;

@RestController
@RequestMapping("/foodprouct")
public class FoodProductController {
  @Autowired
  FoodProductService foodproductservice;
  
  @PostMapping("/save")
 	public ResponseEntity<ResponceStructure<FoodProduct>> saveFoodProdcut(@RequestParam String email,
 			@RequestParam String password, @Validated @RequestBody FoodProduct foodproduct) {
 		return foodproductservice.saveFoodProduct(email, password, foodproduct);
 	}
}
