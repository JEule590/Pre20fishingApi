package com.promineotech.fishingApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.fishingApi.entity.User;
import com.promineotech.fishingApi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getUsers() {
			return new ResponseEntity<Object>(service.getUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getUser(@PathVariable Long userId) {
		try {
			return new ResponseEntity<Object>(service.getUserById(userId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
		
}		
	
	 
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		return new ResponseEntity<Object>(service.createUser(user), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable Long userId) {
		try {
			return new ResponseEntity<Object>(service.updateUser(user, userId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
	
	@RequestMapping(value="/{userId", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteUser(@PathVariable Long userId) {
		try {
			return new ResponseEntity<Object>("successfully deleted user with userId: " + userId, HttpStatus.OK);
		} catch (Exception e) {
			return new  ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	