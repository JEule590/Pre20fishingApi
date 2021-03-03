package com.promineotech.fishingApi.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "waterbody", catalog = "fishing_api")
public class Waterbody {
	
	private Long waterbodyId;
	private Location location;
	private String name;
	private String fisheryType;
	private String species;
 	private Set<Results> resultses = new HashSet<Results>(0);
 	
 	@JsonIgnore
 	private Set<User> users = new HashSet<>();
	
	public Waterbody() {
	}
	 
	public Waterbody(Location location, String name, String fisheryType, String species) {
			this.location = location;
			this.name = name;
			this.fisheryType = fisheryType;
			this.species = species;
	}
	
	public Waterbody(Location location, String name, String fisheryType, String species, Set<Results> resultses) {
		this.location = location;
		this.name = name;
		this.fisheryType = fisheryType;
		this.species = species;
		this.resultses = resultses;
}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "waterbody_id", unique = true, nullable = false)
	public Long getWaterbodyId() {
		return this.waterbodyId;
	}
	
	public void setWaterbodyId(Long waterbodyId) {
		this.waterbodyId = waterbodyId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)      //**********One to One with the Location Table*******
	@JoinColumn(name = "location_id", nullable = false)        //***************************************************
	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	@Column(name = "name", nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "fishery_type", nullable = false, length = 100)
	public String getFisheryType() {
		return this.fisheryType;
	}

	public void setFisheryType(String fisheryType) {
		this.fisheryType = fisheryType;
	}

	@Column(name = "species", nullable = false, length = 200)
	public String getSpecies() {
		return this.species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "waterbody")                //One to Many with the Results Table
	public Set<Results> getResultses() {
		return this.resultses;
	}

	public void setResultses(Set<Results> resultses) {
		this.resultses = resultses;
	}

	
	@ManyToMany(cascade = CascadeType.ALL)                //Many to Many with the User Table
	@JoinTable(name = "fishing_hole",
	joinColumns = @JoinColumn(name = "waterbody_id", referencedColumnName = "waterbody_id"), 
	inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
	public Set<User> getUsers() {         //??getUsers  return users 
		return users;
	}
	
	public void setUsers(Set<User> users) {
		this.users  = users;
	}

 




}
