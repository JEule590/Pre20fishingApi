package com.promineotech.fishingApi.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "results", catalog = "fishing_api")
public class Results {
	
	private Long resultsId;
	private Waterbody waterbody;
	private Long number;
	private Long largest;
	private String methodUsed;
	private Set<Notes> noteses = new HashSet<Notes>(0);
	
	public Results() {
	}
	
    public Results(Long number, Long largest,String methodUsed) {
    	this.number = number;
    	this.largest = largest;
    	this.methodUsed = methodUsed;
    }
    
    public Results(Waterbody waterbody, Long number, Long largest, String methodUsed, Set<Notes> noteses) {
    	this.waterbody = waterbody;
    	this.number = number;
    	this.largest = largest;
    	this.methodUsed = methodUsed;
    	this.noteses = noteses; 
    }
		
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "results_id", unique = true, nullable = false)
	public Long getResultsId() {
		return this.resultsId;
	}
	
	public void setResultsId(Long resultsId) {
		this.resultsId = resultsId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)			//Many to One with the WaterBody Table
	@JoinColumn(name = "waterbody_id") 
	public Waterbody getWaterbody() {       //Jeff to look at again
		return this.waterbody;
	}

	public void setWaterbody(Waterbody waterbody) {
		this.waterbody = waterbody;
	}

	@Column(name = "number", nullable = false)
	public Long getNumber() {
		return this.number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	@Column(name = "largest", nullable = false)
	public Long getLargest() {
		return this.largest;
	}

	public void setLargest(Long largest) {
		this.largest = largest;
	}

	@Column(name = "method_used", nullable = false, length = 100)
	public String getMethodUsed() {
		return this.methodUsed;
	}

	public void setMethodUsed(String methodUsed) {
		this.methodUsed = methodUsed;
	}

	 @OneToMany(fetch = FetchType.LAZY, mappedBy = "results")          //One to Many with the NOtes Table
	public Set<Notes> getNoteses() {
		return this.noteses;
	}

	public void setNoteses(Set<Notes> noteses) {
		this.noteses = noteses;
	}

 
		

}
