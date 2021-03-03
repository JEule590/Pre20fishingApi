package com.promineotech.fishingApi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.fishingApi.entity.Results;
import com.promineotech.fishingApi.repository.ResultsRepositorty;
//import com.promineotech.fishingApi.repository.WaterbodyRepository;


@Service
public class ResultsService {
	
	@Autowired
	private ResultsRepositorty repo;
	
	
//	@Autowired
//	private WaterbodyRepository waterbodyRepo;
	
	public Iterable<Results> getResultses() {
		return repo.findAll();
	}
	
	public Optional<Results> getResultsById(Long resultsId) {
		return repo.findById(resultsId);
	}
	

	
	public Results createResults(Results results) {
		return repo.save(results);
	}
	
	public void deleteResults(Long results_id)  {
		try {
			repo.deleteById(results_id);
		} catch (Exception e) {
			 
		}
	}



	//public void deleteResults(Long resultsId) {
		// TODO Auto-generated method stub
		
	}
//public Optional<Results> getResultsById(long resultsId) throws Exception {
//try {
//	return repo.findById(resultsId);         //findOne(resultsId);
//} catch (Exception e) {
//	throw e;
//}
//}

//public Results createResults(Results results, Long waterbodyId) throws Exception{
//Optional<Waterbody> waterbody = waterbodyRepo.findById(waterbodyId);                          //findOne or findById
//if (waterbody == null) {
//	throw new Exception("Waterbody not found");  
//}
//results.setWaterbody(waterbody);
//return repo.save(results);
//}
