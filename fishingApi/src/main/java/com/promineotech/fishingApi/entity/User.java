package com.promineotech.fishingApi.entity;

 
import static javax.persistence.GenerationType.IDENTITY;

//import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user", catalog = "fishing_api")
public class User {
	
	private Long userId;
	private String firstName;
	private String lastName;
	private String city;
	private String state;
	
	@JsonIgnore
	private Set<Waterbody> waterbodies = new HashSet<>();
	
	public User( ) {
	}
 	
	public User(Long userId, String firstName, String lastName, String city, String state) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city =city;
		this.state = state;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name = "user_id", unique = true, nullable = false)
	public Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "first_name", nullable = false, length = 100)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false, length = 100)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "city", nullable = false, length = 100)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", nullable = false, length = 50)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
	public Set<Waterbody> getWaterbodies() {
		 
		return this.waterbodies;
	}

	public void setWaterbodies(Set<Waterbody> waterbodies) {
		this.waterbodies = waterbodies;
	}
	
}
