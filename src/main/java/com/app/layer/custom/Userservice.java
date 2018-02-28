package com.app.layer.custom;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Userservice {

	@Autowired
	UserDao userDao;

	public User verifyUser(String name, String password) {
		List<User> usersList = userDao.getAllData();
		for (User user : usersList) {
			if (user.getName().equals(name) && user.getPassword().equals(password)) {
				return user;
			}
		}

		return null;
	}

	public List<User> getAllUsers() {
		List<User> usersList = userDao.getAllData();
		return usersList;
	}

	public static String random() {

		SecureRandom test = new SecureRandom();
		int result = test.nextInt(1000000);
		String resultStr = result + "";
		if (resultStr.length() != 6)
			for (int x = resultStr.length(); x < 6; x++)
				resultStr = "0" + resultStr;
		return resultStr;

	}
}
