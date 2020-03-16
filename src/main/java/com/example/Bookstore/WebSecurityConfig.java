package com.example.Bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// Configuring resource permission:
	// Maybe change hasAuthority to hasRole in case of error!
	// Specific authentication requests before broader rules!
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/delete/**").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll();
	}
	
	// Creating in-memory users:
	// plain text encoder is deprecated but its fine in a demo project.
	
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = new ArrayList<UserDetails>();
    	UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

    	users.add(user);
    	
    	user = User.withDefaultPasswordEncoder()
                   .username("admin")
                   .password("admin")
                   .roles("ADMIN")
                   .build();
    	
    	users.add(user);
    	
        return new InMemoryUserDetailsManager(users);
    }
	

}
