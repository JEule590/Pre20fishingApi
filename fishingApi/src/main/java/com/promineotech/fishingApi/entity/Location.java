package com.promineotech.fishingApi.entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "location", catalog = "fishing_api")
public class Location {

	private Long locationId;
	private String state;
	private String city;
	private String road;
	private Set<Waterbody> waterbodies = new HashSet<Waterbody>(0);

	public Location() {
	}

	public Location(String state, String city, String road) {
		this.state = state;
		this.city = city;
		this.road = road;
	}

	public Location(String state, String city, String road, Set<Waterbody> waterbodies) {
		this.state = state;
		this.city = city;
		this.road = road;
		this.waterbodies = waterbodies;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "location_id", unique = true, nullable = false)
	public Long getLocationId() {
		return this.locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	@Column(name = "state", nullable = false, length = 50)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "city", nullable = false, length = 100)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "road", nullable = false, length = 100)
	public String getRoad() {
		return this.road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
	public Set<Waterbody> getWaterbodies() {
		return this.waterbodies;
	}

	public void setWaterbodies(Set<Waterbody> waterbodies) {
		this.waterbodies = waterbodies;
	}

}
