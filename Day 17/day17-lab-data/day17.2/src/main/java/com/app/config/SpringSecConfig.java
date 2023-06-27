package com.app.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Mandatory cls level anno to tell SC --
//following cls is equivalent to bean-config.xml
//going to containg bean configs : @Bean 
@EnableWebSecurity // to enable web sec support
@EnableGlobalMethodSecurity(prePostEnabled = true)
//to enable method level authorization rules
public class SpringSecConfig {
	// dep : password encoder
	@Autowired
	private PasswordEncoder enc;

	// configure a bean for authentication : in mem auth ,
//where user details are not persistent : since going to be stored in mem
	@Bean
	public InMemoryUserDetailsManager myAuthenticate() {
		// this method should return InMemoryUserDetailsManager
		// instance loaded with : InMemoryUserDetailsManager
		// (UserDetails ... details)
		// UserDetails i/f <---- User class (String nm,String pwd ,
		// Collection<GrantedAuthority> coll);
		User admin = new User("Rama", enc.encode("12345"), List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
		User cust1 = new User("Riya", enc.encode("2345"), List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER")));
		User cust2 = new User("Shubham", enc.encode("1245"), List.of(new SimpleGrantedAuthority("ROLE_CUSTOMER")));
		return new InMemoryUserDetailsManager(admin, cust1, cust2);
	}

	// configure another bean for authorization
	@Bean
	public SecurityFilterChain myAuthorization(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests() // simply tell spring sec , to authorize all reqs
				.antMatchers("/products/view").permitAll() // no authentication/ auth required
				.antMatchers("/products/purchase").hasRole("CUSTOMER") // only customer can purchase
				.antMatchers("/products/add").hasRole("ADMIN") // only admin can add the products
				.anyRequest() // any other remaining end points
				.authenticated() // must be : must be
				.and() // bridge
				.httpBasic(); // support Basic authentication

		return http.build();
	}

}
