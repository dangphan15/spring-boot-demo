package com.dangphan.springboot.api;

import com.dangphan.springboot.config.JWTUtils;
import com.dangphan.springboot.dto.UserDTO;
import com.dangphan.springboot.service.impl.MyUserDetailsService;
import com.dangphan.springboot.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/user")
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
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO dto, HttpServletRequest request) throws Exception {
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(dto.getUserName(), dto.getPassword()));
		} catch (BadCredentialsException ex) {
			throw new Exception("Incorrect username or password", ex);
		}
		HttpSession session= request.getSession();
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(dto.getUserName());
		final String jwt = jwtUtils.generateToken(userDetails);
		UserDTO tmpDTO = userService.findByUsername(dto.getUserName());
		tmpDTO.setToken(jwt);
		session.setAttribute("user",tmpDTO);
		return ResponseEntity.ok(tmpDTO);
	}
	@PostMapping("")
	public  UserDTO createUser(@RequestBody UserDTO userDTO){
		return userService.save(userDTO);
	}

	@PutMapping("/{id}")
	public  UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable("id") long id){
		userDTO.setId(id);
		return userService.save(userDTO);
	}
	@GetMapping(value = "/{username}")
	public UserDTO getUser(@PathVariable("username") String username) {

		return userService.findByUsername(username);

	}

	@GetMapping("")
	public UserDTO getSession(HttpServletRequest request) {

		HttpSession session= request.getSession();
		return (UserDTO) session.getAttribute("user");

	}

}
