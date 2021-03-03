package com.promineotech.fishingApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.fishingApi.entity.Results;
import com.promineotech.fishingApi.service.ResultsService;

@RestController
@RequestMapping("/waterbody/{waterbodyId}/resultses")
public class ResultsController {
	
	@Autowired
	private ResultsService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllResultses() {
		return new ResponseEntity<Object>(service.getResultses(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{resultsId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getResults(@PathVariable Long resultsId) {
		return new ResponseEntity<Object>(service.getResultsById(resultsId), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createResults(@RequestBody Results results, @PathVariable Long waterbodyId) {
		 try {
			 return new ResponseEntity<Object>(service.createResults(results), HttpStatus.OK);
		 } catch (Exception e) {
			 return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		 }
	}
	
	@RequestMapping(value="/{resultsId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteResults(@PathVariable Long resultsId) {
		service.deleteResults(resultsId);
		 
	return new ResponseEntity<Object>("Deleted results with resultsId: " + resultsId, HttpStatus.OK);
   }

}