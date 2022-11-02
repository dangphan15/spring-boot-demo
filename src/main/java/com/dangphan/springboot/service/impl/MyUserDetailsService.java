package com.dangphan.springboot.service.impl;

import java.util.ArrayList;
import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dangphan.springboot.dto.UserDTO;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	 private UserService userService;

	@Override
    @Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		UserDTO userDTO = userService.findByUsername(username);
		if (userDTO == null)
		       throw new UsernameNotFoundException("Bad credentials");

		for (String roleName : userDTO.getRoleNames()) {
			authorities.add(new SimpleGrantedAuthority(roleName));
		}
		return new User(userDTO.getUserName(), userDTO.getPassword(), authorities);
	}

}
