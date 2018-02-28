package com.app.layer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@SpringBootApplication(scanBasePackages = {"com.app.layer"})
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableResourceServer
public class WebServiceAuthenticatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceAuthenticatorApplication.class, args);
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}
	
}
