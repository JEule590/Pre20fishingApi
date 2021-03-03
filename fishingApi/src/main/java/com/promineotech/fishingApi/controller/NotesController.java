package com.promineotech.fishingApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.fishingApi.entity.Notes;
import com.promineotech.fishingApi.service.NotesService;

@RestController
@RequestMapping("/{noteses}")        //("/user/{userId}/waterBody/{waterbodyId}/results/{resultsId}/notes")
public class NotesController {
	
	@Autowired
	private NotesService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createNotes(@RequestBody Notes notes, @PathVariable Long resultsId) {
		try {
			return new ResponseEntity<Object>(service.createNotes(notes), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{notesId}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteNotes(@PathVariable Long notesId)   {        //?????????
		try {
			service.deleteNotes(notesId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<Object>("Deleted notes with notesId: " +  notesId, HttpStatus.OK);
	}

}
