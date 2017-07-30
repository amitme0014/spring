package com.igate.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class Login implements Serializable{
	
	@NotEmpty(message="Name cannot be empty")
	private String userName;
	@NotEmpty(message="Password cannot be empty")
	private String password;
	
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
	
	

}
