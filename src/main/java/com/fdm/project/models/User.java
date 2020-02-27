package com.fdm.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private String email;
	private String name;
	private Integer age;
	private Integer institute1;
	private Integer institute2;
	private Integer institute3;
	private Integer institute4;
	private Integer institute5;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getInstitute1() {
		return institute1;
	}
	public void setInstitute1(Integer institute1) {
		this.institute1 = institute1;
	}
	public Integer getInstitute2() {
		return institute2;
	}
	public void setInstitute2(Integer institute2) {
		this.institute2 = institute2;
	}
	public Integer getInstitute3() {
		return institute3;
	}
	public void setInstitute3(Integer institute3) {
		this.institute3 = institute3;
	}
	public Integer getInstitute4() {
		return institute4;
	}
	public void setInstitute4(Integer institute4) {
		this.institute4 = institute4;
	}
	public Integer getInstitute5() {
		return institute5;
	}
	public void setInstitute5(Integer institute5) {
		this.institute5 = institute5;
	}


	
	
	
	

}
