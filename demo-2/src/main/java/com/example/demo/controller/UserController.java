package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserServices;
import com.example.exceptions.ProductNotFound;

@RestController
public class UserController {
	
	@Autowired
	UserServices services;
	
	@Autowired
	UserRepository userRepository ;
	
	@GetMapping("/users")
   public List<User> list(){
	return services.listAll();
   }
	
	 @GetMapping("/users/{id}")
	 public ResponseEntity<User> get(@PathVariable Integer id) 
	 {
	 try
	 {
	 User user = services.get(id);
	 return new ResponseEntity<User>(user, HttpStatus.OK);
	 } 

	 catch(ProductNotFound ex)
	 {
		
		 return new ResponseEntity<Product>( HttpStatus.NOT_FOUND);
	 }
	 }
}
