package com.poc.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@EnableAutoConfiguration
@Service("customUserDetailsService")
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Override
	@Bean
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		try {
			User user = userDetailsServiceImpl.findByUserName(name);
			if(user==null){
			    throw new UsernameNotFoundException("Username not found");
			}
			  return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), 
		                 true, true, true, true, getGrantedAuthorities(user));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	@Bean
	 private List<GrantedAuthority> getGrantedAuthorities(User user){
	        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	         
	     
	            
	            authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole()));
	            
	      
	        return authorities;
	    }

	
	
}
