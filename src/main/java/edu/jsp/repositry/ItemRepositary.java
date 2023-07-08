package edu.jsp.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.entity.Item;

public interface ItemRepositary extends JpaRepository<Item, Long> {

	  

		Optional<Item> findItemByName(String name);
}
