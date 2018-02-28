package com.app.layer.custom;

import org.springframework.stereotype.Component;

@Component
public class User {

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String password,  String role) {
		this.name =name;
		this.password =password;
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private long id;
	private String name;
	private String password;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
