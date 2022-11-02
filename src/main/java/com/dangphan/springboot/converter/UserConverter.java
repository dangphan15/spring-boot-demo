package com.dangphan.springboot.converter;

import org.springframework.stereotype.Component;

import com.dangphan.springboot.dto.UserDTO;
import com.dangphan.springboot.entity.UserEntity;

@Component
public class UserConverter {

	public UserEntity toEntity(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(userDTO.getUserName());
		userEntity.setPassword(userDTO.getPassword());
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
		return userDTO;
	}
}
