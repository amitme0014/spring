package com.igate.demo;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("loginDao")
public class LoginDao {
	
	Logger myLog;
	
	public LoginDao()
	{
		myLog = Logger.getLogger(LogInfo.class);
	}
	
	public boolean validate(Login login)
	{
		if(login.getUserName().equals("user") && login.getPassword().equals("user"))
		{
			myLog.info("User successfully Logged In");
			return true;
		}
		else
		{
			myLog.info("Login FAILS!!!");
			return false;
		}
	}

}
