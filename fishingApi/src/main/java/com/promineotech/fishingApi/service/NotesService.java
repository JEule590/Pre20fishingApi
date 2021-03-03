package com.promineotech.fishingApi.service;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.fishingApi.entity.Notes;
import com.promineotech.fishingApi.repository.NotesRepository;

@Service
public class NotesService {

	@Autowired
	private NotesRepository repo;
	
	public Notes getNotesById(long notesId) {
		try {
			return repo.findById(notesId).orElseThrow();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public Notes createNotes(Notes notes) {
		return repo.save(notes);
	}
	 
	public void deleteNotes(Long notesId) throws Exception {
		try {
			repo.deleteById(notesId);
		}catch (Exception e) {
			throw new Exception();
		}
	}
}
