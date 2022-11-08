package com.dangphan.springboot.converter;

import com.dangphan.springboot.entity.RoleEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dangphan.springboot.dto.UserDTO;
import com.dangphan.springboot.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	public UserEntity toEntity(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(userDTO.getUserName());
		userEntity.setPassword(passwordEncoder().encode(userDTO.getPassword()));
		userEntity.setFullName(userDTO.getFullName());
		userEntity.setStatus(userDTO.getStatus());
		return userEntity;
	}

	public UserEntity toEntity(UserDTO userDTO,UserEntity userEntity){
		userEntity.setUserName(userDTO.getUserName());
		userEntity.setPassword(passwordEncoder().encode(userDTO.getPassword()));
		userEntity.setFullName(userDTO.getFullName());
		userEntity.setStatus(userDTO.getStatus());
		return userEntity;
	}

	public UserDTO toDTO(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		if(userEntity.getId()!=null) {
			userDTO.setId(userEntity.getId());
		}
		userDTO.setUserName(userEntity.getUserName());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setFullName(userEntity.getFullName());
		userDTO.setStatus(userEntity.getStatus());
		userDTO.setCreatedDate(userEntity.getCreatedDate());
		userDTO.setCreatedBy(userEntity.getCreatedBy());
		userDTO.setModifiedDate(userEntity.getModifiedDate());
		userDTO.setModifiedBy(userEntity.getModifiedBy());

		//set role for userDTO
		List<String> roleNames=new ArrayList<>();
		for(RoleEntity role: userEntity.getRoles()) {
			roleNames.add(role.getName());
		}
		userDTO.setRoleNames(roleNames);
		return userDTO;
	}
}
