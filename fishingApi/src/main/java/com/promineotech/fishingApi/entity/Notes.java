package com.promineotech.fishingApi.entity;

 

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 

@Entity
@Table(name = "notes", catalog = "fishing_api")
public class Notes {
	private Long notesId;
	private Results results;
	private String note;
	
	public Notes() {
	}
	
	public Notes(Results results, String note) {
		this.results = results;
		this.note = note;
	}	
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "notes_id", unique = true, nullable = false)
 	public Long getNotesId() {
		return this.notesId;
	}
	
	public void setNotesId(Long notesId) {
		this.notesId = notesId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)          //Many to One with the Results Table
	@JoinColumn(name ="results_id", nullable = false)
	public Results getResults() {
		return results;
	}
	public void setResults(Results results) {
		this.results = results;
	}
	
	@Column(name = "note", nullable = false, length = 250)
	public String getNote() {
		return this.note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}





 
