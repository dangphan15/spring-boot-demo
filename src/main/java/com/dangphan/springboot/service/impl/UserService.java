package com.dangphan.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dangphan.springboot.entity.CategoryEntity;
import com.dangphan.springboot.entity.NewEntity;
import com.dangphan.springboot.repository.RoleRepository;
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
	private RoleRepository roleRepository;

	@Autowired
	private UserConverter userConverter;

	@Override
	public UserDTO findByUsername(String username) {
		UserDTO userDTO = new UserDTO();
		UserEntity userEntity = new UserEntity();
		userEntity = userRepository.findByUserName(username);
		userDTO = userConverter.toDTO(userEntity);
		return userDTO;
	}

	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		List<String> roleNames=new ArrayList<>();
		if (userDTO.getId() != null) {
			UserEntity oldUser = new UserEntity();
			Optional<UserEntity> oldUserEntity = userRepository.findById(userDTO.getId());
			if (oldUserEntity.isPresent()) {
				oldUser = oldUserEntity.get();
			}
			userEntity = userConverter.toEntity(userDTO, oldUser);
		} else {
			userEntity = userConverter.toEntity(userDTO);
		}
		roleNames=userDTO.getRoleNames();
		List<RoleEntity> roleEntityList=new ArrayList<>();
		for(String role: roleNames){
			RoleEntity roleEntity=roleRepository.findByName(role);
			roleEntityList.add(roleEntity);
		}
		userEntity.setRoles(roleEntityList);
		userEntity = userRepository.save(userEntity);
		return userConverter.toDTO(userEntity);
	}

	// SET ROLES FOR USER ENTITY
}
