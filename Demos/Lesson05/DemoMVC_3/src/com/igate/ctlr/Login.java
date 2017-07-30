package com.igate.ctlr;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {
	
	private String userName;
	private String password;
	
	
	@NotEmpty(message="user name is required")
	@Size(min=4,message="user name should have atleast 4 characters")

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@NotEmpty(message="password is required")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
