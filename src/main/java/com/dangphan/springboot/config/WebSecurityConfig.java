package com.dangphan.springboot.config;

import com.dangphan.springboot.filter.JWTRequestFilter;
import com.dangphan.springboot.service.impl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private JWTRequestFilter jwtRequestFilter;

	@Bean
	public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder bCryptPasswordEncoder,
			MyUserDetailsService userDetailsService) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userDetailsService)
				.passwordEncoder(bCryptPasswordEncoder).and().build();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/all").permitAll()
		.antMatchers("/api/user/login").permitAll()
		.antMatchers("/api/news/**").hasAuthority("ADMIN")
		.antMatchers("/api/user").hasAuthority("USER")
				.anyRequest().authenticated()
//		.and()
//		.formLogin().loginPage("/login").loginProcessingUrl("/login")
//		.defaultSuccessUrl("/").permitAll()
//		.and()
//		.logout().permitAll()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.debug(false).ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**",
				"/favicon.ico");
	}
}
