package edu.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.jsp.entity.Item;
import edu.jsp.exception.ItemByIdNotFoundException;
import edu.jsp.exception.ItemByNameNotFoundException;
import edu.jsp.repositry.ItemRepositary;

@Repository
public class ItemDao 
{   
	@Autowired
    private ItemRepositary irepositary;
	
	public Item saveItem(Item item) {
		return irepositary.save(item);
	}
	
	public List<Item> findAll(){
		return irepositary.findAll();
	}
	
	public Item findItemById(long id) {
		 Optional<Item> items=irepositary.findById(id);
		 if(items.isPresent()) {
			 return items.get();
		 }
		 throw new ItemByIdNotFoundException("The Item by Id not found");
	}
	
	public Item findItemByName(String name)  {
		 Optional<Item> items=irepositary.findItemByName(name);
		 if(items.isPresent()) {
			 return items.get();
		 }
		 throw new ItemByNameNotFoundException("The Item by Name not found");
	}
	
	public String deleteItem(String name) {
		irepositary.delete(findItemByName(name));
		return "Item Deleted";
	}
	
	
	
}
