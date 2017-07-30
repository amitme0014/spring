package com.igate.dto;


import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	@NotEmpty(message="First Name is mandatory")
	@Size(min=4,max=8,message="Minimum 4 and Maximum 8 characters required")
	private String userName;
	
	private String password;
	private char gender ;
	@Email(message="Please enter valid Email ID")
	private String email;
	private String[] skillSet;
	private String city;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(String[] skillSet) {
		this.skillSet = skillSet;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}


}
