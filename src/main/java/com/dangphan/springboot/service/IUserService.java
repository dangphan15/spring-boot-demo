package com.dangphan.springboot.service;

import com.dangphan.springboot.dto.UserDTO;

public interface IUserService {
	UserDTO findByUsername(String username);

	UserDTO save(UserDTO userDTO);
}