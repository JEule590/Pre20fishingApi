package com.promineotech.fishingApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.fishingApi.entity.Waterbody;
import com.promineotech.fishingApi.service.WaterbodyService;

@RestController
@RequestMapping("/users/{userId/waterbodies")
public class WaterbodyController {

	@Autowired
	private WaterbodyService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllWaterbodies() {
		return new ResponseEntity<Object>(service.getWaterbodyies(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{waterbodyId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getWaterbody(@PathVariable Long waterbodyId) {
		return new ResponseEntity<Object>(service.getWaterbodyById(waterbodyId), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createWaterbody(@RequestBody Waterbody waterbody, @PathVariable Long userId) {
		try {
			return new ResponseEntity<Object>(service.createWaterbody(waterbody), HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="{waterbodyId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteWaterbody(@PathVariable Long waterbodyId) {
		try {
			service.deleteWaterbody(waterbodyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<Object>("Delete waterbody with waterbodyId: " + waterbodyId, HttpStatus.OK);
	}
}
