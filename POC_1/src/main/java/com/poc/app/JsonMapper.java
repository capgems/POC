package com.poc.app;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JsonMapper {
	
	
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	private List<User> userList;
}
