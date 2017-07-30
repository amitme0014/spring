package com.igate.demo;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {
	
	private String userName;
	private String password;
		
	@NotEmpty(message="username cannot be empty")
	public String getUserName() {
		return userName;
	}
	
	@NotEmpty(message="password cannot be empty")
	public String getPassword() {
		return password;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
