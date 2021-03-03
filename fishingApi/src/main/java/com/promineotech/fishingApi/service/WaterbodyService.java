package com.promineotech.fishingApi.service;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.fishingApi.entity.Waterbody;
import com.promineotech.fishingApi.repository.WaterbodyRepository;


@Service
public class WaterbodyService {
	
   @Autowired
   private WaterbodyRepository repo;
 
   public Iterable<Waterbody> getWaterbodyies() {
	   return repo.findAll();
   }
   
   public Waterbody getWaterbodyById(Long waterbodyId ) {
		return repo.findById(waterbodyId).orElseThrow();
	}
 
   public Waterbody createWaterbody(Waterbody waterbody) {     //add or create???
	   return repo.save(waterbody);
   }
   
  public void deleteWaterbody(Long waterbodyId) throws Exception {
	   try {
		   repo.deleteById(waterbodyId);
	   } catch (Exception e) {
		   throw new Exception();
	   }
   }
 
}
 
//public Waterbody updateWaterbody(Long waterbodyId, Waterbody waterbody) {
//Waterbody foundWaterbody = repo.findOne(waterbodyId);
//if(foundWaterbody !=null) {
//	foundWaterbody.setName(waterbody.getName());
//	foundWaterbody.setFisheryType(waterbody.getFisheryType());
//	foundWaterbody.setSpecies(waterbody.getSpecies());
//	foundWaterbody.setLocation(waterbody.getLocation());
//	repo.save(foundWaterbody);
//}
//return foundWaterbody;
//}
 
