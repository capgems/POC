package com.poc.app;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@EnableAutoConfiguration
public class DemoApplication {

	
	File file;
	JsonMapper usersList = null;
	List<User> users =new ArrayList<User>();
	public DemoApplication() throws IOException {
		 file  = new File("metadata.json");
		if(!file.exists()) {
			file.createNewFile();
		}else {
			readContents();
		}
	}
	
	@Bean
	public List<User> readContents() throws JsonGenerationException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new  ObjectMapper();
		
		usersList = mapper.readValue(file, JsonMapper.class);
		
	
			users.addAll(usersList.getUserList());
			usersList.setUserList(users);
			// mapper.writeValue(file, usersList);
			return usersList.getUserList();
	       
	}
	@Bean
	public String writeContents() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new  ObjectMapper();
		User user = new User();
		user.setId(Integer.parseInt(random()));
		user.setName("Shyam");
		user.setPassword("111");
			users.add(user);
			
			mapper.writeValue(file, usersList);
			
			return "Done";
	}
	
	public static String random() {
		

		SecureRandom test = new SecureRandom();
		int result = test.nextInt(1000000);
		String resultStr = result + "";
		if (resultStr.length() != 6) 
		    for (int x = resultStr.length(); x < 6; x++) resultStr = "0" + resultStr;
	return resultStr;
		
	}
}
