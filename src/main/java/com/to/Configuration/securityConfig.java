package com.to.Configuration;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class securityConfig  extends WebSecurityConfigurerAdapter  {
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 //http.httpBasic().disable();
		
		http	.csrf().disable()	.antMatcher("/**")
		.authorizeRequests().antMatchers("/","/login","/webjars/**", "/error**").permitAll()
		.anyRequest().authenticated()
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
		
	}
	
	       
	


}