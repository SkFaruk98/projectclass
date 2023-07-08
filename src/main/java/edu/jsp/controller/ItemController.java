package edu.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.config.ResponceStructure;
import edu.jsp.entity.Item;
import edu.jsp.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
    ItemService itemservice;
    
	@PostMapping("/save")
	public ResponseEntity<ResponceStructure<List<Item>>> saveItem(@RequestParam String email,@RequestParam String password, @Validated @RequestBody List<Item> item) {
		return itemservice.saveItem(email, password, item);
	}
	
	@GetMapping("/showall")
	public ResponseEntity<ResponceStructure<List<Item>>>  showItem(){
		return itemservice.showAllItems();
	}
	
	@GetMapping("/showbyname")
	public ResponseEntity<ResponceStructure<Item>> finditembyName(@RequestParam String name){
		return itemservice.finditemByname(name);
	}
	
	@PostMapping("/updatecost")
	public ResponseEntity<ResponceStructure<Item>> updatePriceofItem(@RequestParam String email, @RequestParam String password,
			@RequestParam String itemname, @RequestParam double updatePrice) {
		 return itemservice.updateCostofItem(email, password, itemname, updatePrice);
	}
			
	@DeleteMapping("/delete")
	public ResponseEntity<ResponceStructure<String>> deleteItem(@RequestParam String email,@RequestParam String password,@RequestParam String name) {
		return itemservice.deleteUser(email, password, name);
	}
}
