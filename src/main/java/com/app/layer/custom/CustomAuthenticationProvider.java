package com.app.layer.custom;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	Userservice userService;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		User userObj = userService.verifyUser(auth.getName().toString(), auth.getCredentials().toString());
		
		if (userObj == null) {
			throw new BadCredentialsException("authentication failed");
		} else {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(userObj.getRole()));
			return new UsernamePasswordAuthenticationToken(userObj.getName(), userObj.getPassword(), authorities);
		}
	}

	@Override
	public boolean supports(Class<?> auth) {
		// TODO Auto-generated method stub
		return  auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
