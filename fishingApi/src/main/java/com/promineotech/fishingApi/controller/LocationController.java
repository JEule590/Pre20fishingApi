package com.promineotech.fishingApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.fishingApi.entity.Location;
import com.promineotech.fishingApi.service.LocationService;

@RestController
@RequestMapping("/waterbody/{waterbodyId}/location")
public class LocationController {
	
	@Autowired
	private LocationService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createLocation(@RequestBody Location location, @PathVariable Long waterbodyId) {
		try {
			return new ResponseEntity<Object>(service.createLocation(location, waterbodyId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{locationId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteLocation(@PathVariable Long locationId)  {   //?????
		try {
			service.deleteLocation(locationId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("Deleted location with id: "  +  locationId, HttpStatus.OK);
	}
	
}
