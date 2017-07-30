package com.igate.pl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.igate.bean.User;
import com.igate.service.UserServiceIntf;

public class Example {

	public static void main(String s[]) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"config.xml");
		UserServiceIntf ui = (UserServiceIntf) ctx.getBean("userService");
		List<User> l = ui.displayUsers();
		for (User u : l) {
			System.out.println(u.getUsername());
		}
	}

}
