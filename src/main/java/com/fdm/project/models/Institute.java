package com.fdm.project.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Institute {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String speciality;
	private String information;	
	private String address;
	private String image;
	private Integer user1;
	private Integer user2;
	private Integer user3;
	private Integer user4;
	private Integer user5;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getUser1() {
		return user1;
	}
	public void setUser1(Integer user1) {
		this.user1 = user1;
	}
	public Integer getUser2() {
		return user2;
	}
	public void setUser2(Integer user2) {
		this.user2 = user2;
	}
	public Integer getUser3() {
		return user3;
	}
	public void setUser3(Integer user3) {
		this.user3 = user3;
	}
	public Integer getUser4() {
		return user4;
	}
	public void setUser4(Integer user4) {
		this.user4 = user4;
	}
	public Integer getUser5() {
		return user5;
	}
	public void setUser5(Integer user5) {
		this.user5 = user5;
	}

	
	
	
}
