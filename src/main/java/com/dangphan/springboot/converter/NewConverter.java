package com.dangphan.springboot.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dangphan.springboot.dto.NewDTO;
import com.dangphan.springboot.entity.NewEntity;

@Component
public class NewConverter {
		
	public NewEntity toEntity(NewDTO newDto) {
		NewEntity newEntity = new NewEntity();
		newEntity.setTitle(newDto.getTitle());
		newEntity.setContent(newDto.getContent());
		newEntity.setShortDescription(newDto.getShortDescription());
		newEntity.setThumbnail(newDto.getThumbnail());
		return newEntity;
	}

	public NewDTO toDTO(NewEntity newEntity) {
		NewDTO newDto = new NewDTO();
		if(newEntity.getId()!=null) {
			newDto.setId(newEntity.getId());
		}
		newDto.setTitle(newEntity.getTitle());
		newDto.setContent(newEntity.getContent());
		newDto.setShortDescription(newEntity.getShortDescription());
		newDto.setThumbnail(newEntity.getThumbnail());
		newDto.setCreatedDate(newEntity.getCreatedDate());
		newDto.setCreatedBy(newEntity.getCreatedBy());
		newDto.setModifiedDate(newEntity.getModifiedDate());
		newDto.setModifiedBy(newEntity.getModifiedBy());
		return newDto;
	}

	public NewEntity toEntity(NewDTO newDto, NewEntity newEntity) {
		newEntity.setTitle(newDto.getTitle());
		newEntity.setContent(newDto.getContent());
		newEntity.setShortDescription(newDto.getShortDescription());
		newEntity.setThumbnail(newDto.getThumbnail());
		return newEntity;
	}
	
	public List<NewDTO> toDTO(List<NewEntity> listNewEntity) {
		List<NewDTO> listNewDto = new ArrayList<NewDTO>();
		for (NewEntity newEntity : listNewEntity) {
			NewDTO newDto = new NewDTO();
			if(newEntity.getId()!=null) {
				newDto.setId(newEntity.getId());
			}
			newDto.setTitle(newEntity.getTitle());
			newDto.setContent(newEntity.getContent());
			newDto.setShortDescription(newEntity.getShortDescription());
			newDto.setThumbnail(newEntity.getThumbnail());
			listNewDto.add(newDto);
		}
		return listNewDto;
	}
}
