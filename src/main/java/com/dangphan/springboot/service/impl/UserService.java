package com.dangphan.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangphan.springboot.converter.UserConverter;
import com.dangphan.springboot.dto.UserDTO;
import com.dangphan.springboot.entity.RoleEntity;
import com.dangphan.springboot.entity.UserEntity;
import com.dangphan.springboot.repository.UserRepository;
import com.dangphan.springboot.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO findByUsername(String username) {
		UserDTO userDTO = new UserDTO();
		UserEntity userEntity = new UserEntity();
		List<String> roleNames=new ArrayList<>();
		userEntity = userRepository.findByUserName(username);
		for(RoleEntity role: userEntity.getRoles()) {
			roleNames.add(role.getName());
		}
		userDTO = userConverter.toDTO(userEntity);
		userDTO.setRoleNames(roleNames);
		return userDTO;
	}

}
