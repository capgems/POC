package com.app.layer.custom;

import java.io.BufferedReader;  
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class UserDao {

	
	File file;
	FileWriter fw;
	JsonMapper usersList = null;
	List<User> users =new ArrayList<User>();
	private Gson gson;
	private BufferedReader br;
	
	public UserDao() throws IOException{
		 this.file  = new File("users.json");
		 this.usersList = new JsonMapper();
		 this.gson = new Gson();
		if(!file.exists()) {
			file.createNewFile();
			this.usersList.setUserList(Arrays.asList(new User("admin", "admin","ADMIN")));
			doWrite();
		}else {
			gettingListsAndUpdate();
		}
		
	}
	
	
	
	public void gettingListsAndUpdate()  {
		
		
		try {
			br = new BufferedReader(new FileReader("users.json"));
			if(br!=null){
				this.usersList = gson.fromJson(this.br, JsonMapper.class);
			}
			
			br.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
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
	public void doWrite() {
		try {
			this.fw = new FileWriter("users.json");
			fw.write(gson.toJson(this.usersList));
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllData() {
		this.gettingListsAndUpdate();
		return this.usersList.getUserList();
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
