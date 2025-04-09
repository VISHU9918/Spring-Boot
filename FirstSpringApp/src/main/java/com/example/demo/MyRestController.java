package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRestController {
	
	// Static list to simulate an in-memory storage for products
	
	private static List<Product>productList= new ArrayList<>();
	
	//Load  products (initial mock data)
	static {
		productList.add(new Product(1,"Laptop",75000));
		productList.add(new Product(2,"Mobile",20000));
		productList.add(new Product(3,"External Disk",10000));
		productList.add(new Product(4,"USB",1000));
	}
	
	//Get all products
	@GetMapping("/products")
	public List<Product>getAllProducts(){
		return productList;
	}
	
	// Get product by ID
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		// Return product  by index (adjust for zero-indexed list)
		if(id>=0 && id< productList.size()) {
			return productList.get(id);
		}
		else
			return null;
		
	}
	
	//Save a new product
	@PostMapping("/products")
	public Product  saveProduct(@RequestBody Product newProduct) {
		// Add the new product to the list
		productList.add(newProduct);
		return newProduct;
	}
	
	//Update an existing product
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable("id") int id, @RequestBody Product updateProduct) {
		// Validate the ID
		if(id>=0 && id<productList.size()) {
			Product existingProduct= productList.get(id);
			existingProduct.setName(updateProduct.getName());
			existingProduct.setCost(updateProduct.getCost());
			return existingProduct;
		}
		else
			return null;
	}
	
	// Delete a product by ID
	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		// Validate the ID
		if(id>=0 && id< productList.size()) {
			productList.remove(id);
			return "Product with id " + id+ " was deleted.";
		}
		else {
			return null;
		}
	}

}
