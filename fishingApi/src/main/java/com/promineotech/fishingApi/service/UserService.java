package com.promineotech.fishingApi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.fishingApi.entity.User;
import com.promineotech.fishingApi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;


	public Iterable<User> getUsers() {
		return repo.findAll();
	}
	
	public Optional<User> getUserById(Long userId ) {
		return repo.findById(userId);
	}
	
	public User createUser(User user) {
		return repo.save(user);
	}

  	public User updateUser(User user, Long userId) {
		User foundUser = repo.findById(userId).orElseThrow();
		if(foundUser !=null) {
			foundUser.setLastName(user.getFirstName());
			foundUser.setLastName(user.getLastName());
			foundUser.setCity(user.getCity());
			foundUser.setState(user.getState());
			  repo.save(foundUser);
		}
		 return foundUser;
	}
	
	public void deleteCustomer(Long userId) throws Exception {
		try {
			repo.deleteById(userId);
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
} 
