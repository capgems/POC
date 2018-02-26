package com.poc.app;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl {

	@Autowired
	DemoApplication demoApplication;

	@Bean
	public User findByUserName(String name) throws JsonGenerationException, JsonMappingException, IOException {

		for (User users : demoApplication.readContents()) {

			if(name.equalsIgnoreCase(users.getName())){
				return users;
			}
		}
		return null;
	}
}
