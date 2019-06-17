package com.app.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepository;
@Component
public class ConsoleRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	public void run(String... args) throws Exception {
		
		
		  //Insert 
		repo.save(new Product(10, "A", 1.1)); 
		repo.save(new Product(11, "B", 2.1)); 
		repo.save(new Product(12, "C", 3.1)); 
		repo.save(new Product(13, "D", 4.1)); 
		repo.save(new Product(14, "E", 5.1)); 
		repo.save(new Product(15, "F", 6.1));
		  
		  //Update 
		repo.save(new Product(13, "DDD", 4.1));
		  
		  // Bulk Insert 
		List<Product> pds = Arrays.asList( 
				new Product(16, "G", 7.1),
				new Product(17, "H", 8.1), 
				new Product(18, "I", 9.1), 
				new Product(19, "J", 1.1), 
				new Product(20, "K", 2.1), 
				new Product(21, "L", 3.1)
		  
		  ); 
		repo.saveAll(pds); 
		 
		
		// Fetch one Row
		Optional<Product> p = repo.findById(10);
		if(p.isPresent())
		{
			//Avoid NPE
			Product prd = p.get();
			System.out.println(prd.getProdCode());
		}
		
		
		  //Fetch All Records 
		List<Product> list = repo.findAll();
		list.forEach(System.out::println);
		  
		  // Delete one Record 
		//repo.deleteById(10);
		  
		  // Delete All Records 
		//repo.deleteAll(); repo.deleteAllInBatch();
		 
	}

}
