package com.fdm.project.models;

public class UserInstituteMatch {
	
	private long userId;
	private String username;
	private String password;
	private String email;
	private String fullname;
	private Integer age;
	private Integer institute1;
	private Integer institute2;
	private Integer institute3;
	private Integer institute4;
	private Integer institute5;
	
	private long instituteId;
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


	public UserInstituteMatch(User user, Institute institute) {
		super();
		this.userId = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.fullname = user.getName();
		this.age = user.getAge();
		this.institute1 = user.getInstitute1();
		this.institute2 = user.getInstitute2();
		this.institute3 = user.getInstitute3();
		this.institute4 = user.getInstitute4();
		this.institute5 = user.getInstitute5();
		
		this.instituteId = institute.getId();
		this.name = institute.getName();
		this.speciality = institute.getSpeciality();
		this.information = institute.getInformation();
		this.address = institute.getAddress();
		this.image = institute.getImage();
		this.user1 = institute.getUser1();
		this.user2 = institute.getUser2();
		this.user3 = institute.getUser3();
		this.user4 = institute.getUser4();
		this.user5 = institute.getUser5();
		}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
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


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
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


	public long getInstituteId() {
		return instituteId;
	}


	public void setInstituteId(long instituteId) {
		this.instituteId = instituteId;
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


	@Override
	public String toString() {
		return "UserInstituteMatch [userId=" + userId + ", username=" + username + ", password=" + password + ", email="
				+ email + ", fullname=" + fullname + ", age=" + age + ", institute1=" + institute1 + ", institute2="
				+ institute2 + ", institute3=" + institute3 + ", institute4=" + institute4 + ", institute5="
				+ institute5 + ", instituteId=" + instituteId + ", name=" + name + ", speciality=" + speciality
				+ ", information=" + information + ", address=" + address + ", image=" + image + ", user1=" + user1
				+ ", user2=" + user2 + ", user3=" + user3 + ", user4=" + user4 + ", user5=" + user5 + "]";
	}
	
	
	

}
