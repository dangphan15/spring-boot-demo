package com.dangphan.springboot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dangphan.springboot.config.JWTUtils;
import com.dangphan.springboot.dto.NewDTO;
import com.dangphan.springboot.dto.UserDTO;
import com.dangphan.springboot.service.impl.MyUserDetailsService;
import com.dangphan.springboot.service.impl.UserService;

@RestController
public class UserAPI {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	private JWTUtils jwtUtils;

	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO dto) throws Exception {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(dto.getUserName(), dto.getPassword()));
		} catch (BadCredentialsException ex) {
			throw new Exception("Incorrect username or password", ex);
		}
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(dto.getUserName());
		final String jwt = jwtUtils.generateToken(userDetails);
		UserDTO tmpDTO = userService.findByUsername(dto.getUserName());
		return ResponseEntity.ok(new UserDTO(jwt, tmpDTO.getUserName()));
	}

	@GetMapping(value = "/username/{username}")
	public UserDetails getUser(@PathVariable("username") String username) {
		return myUserDetailsService.loadUserByUsername(username);
	}

}
