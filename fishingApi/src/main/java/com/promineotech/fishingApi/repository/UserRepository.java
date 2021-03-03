package com.promineotech.fishingApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.fishingApi.entity.User;
 

public interface UserRepository extends CrudRepository<User, Long>{
	
	//User findOne(Object userId);


}
