package com.promineotech.fishingApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.fishingApi.entity.Waterbody;

public interface WaterbodyRepository extends CrudRepository<Waterbody, Long>{

 //	Waterbody findOne(Long waterbodyId);

}
