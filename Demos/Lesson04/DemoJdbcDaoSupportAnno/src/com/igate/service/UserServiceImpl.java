package com.igate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igate.bean.User;
import com.igate.dao.UserDaoIntf;

@Service("userService")
public class UserServiceImpl implements UserServiceIntf {
	@Autowired
	UserDaoIntf userDao;
	@Override
	public List<User> displayUsers() {
		return userDao.displayUsers();
	}

}
