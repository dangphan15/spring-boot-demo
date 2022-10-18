package com.dangphan.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dangphan.springboot.converter.NewConverter;
import com.dangphan.springboot.dto.NewDTO;
import com.dangphan.springboot.entity.CategoryEntity;
import com.dangphan.springboot.entity.NewEntity;
import com.dangphan.springboot.repository.CategoryRepository;
import com.dangphan.springboot.repository.NewRepository;
import com.dangphan.springboot.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;

	@Autowired
	private CategoryRepository categoryRespository;

	@Autowired
	private NewConverter newConverter;

	//-----------Insert News-----------------------------
	@Override
	public NewDTO save(NewDTO newDto) {
		NewEntity newEntity = new NewEntity();
		if (newDto.getId() != null) {
			NewEntity oldNew = new NewEntity();
			Optional<NewEntity> oldNewEntity = newRepository.findById(newDto.getId());
			if (oldNewEntity.isPresent()) {
				oldNew = oldNewEntity.get();
			}
			newEntity = newConverter.toEntity(newDto, oldNew);
		} else {
			newEntity = newConverter.toEntity(newDto);
		}
		CategoryEntity categoryEntity = categoryRespository.findOneByCode(newDto.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}


	//-----------Update News-----------------------------
	@Override
	public NewDTO update(NewDTO newDto) {

		NewEntity oldNew = new NewEntity();
		Optional<NewEntity> oldNewEntity = newRepository.findById(newDto.getId());
		if (oldNewEntity.isPresent()) {
			oldNew = oldNewEntity.get();
		}
		NewEntity newEntity = newConverter.toEntity(newDto, oldNew);
		CategoryEntity categoryEntity = categoryRespository.findOneByCode(newDto.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}


	//-----------Delete News-----------------------------
	@Override
	public void delete(long[] ids) {
		for (long item : ids) {
			newRepository.deleteById(item);
		}
	}


	//-----------Find News-----------------------------
	

	//Find News Pageable
	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		for (NewEntity newEntity: entities) {
			NewDTO newDto = newConverter.toDTO(newEntity);
			CategoryEntity oldCategory = new CategoryEntity();
			Optional<CategoryEntity> categoryEntity = categoryRespository.findById(newEntity.getCategory().getId());
			if (categoryEntity.isPresent()) {
				oldCategory = categoryEntity.get();
			}
			newDto.setCategoryCode(oldCategory.getCode());
			results.add(newDto);
		}
		return results;
	}

	@Override
	public int totalItem() {
		return (int) newRepository.count();
	}
	
	//Find News not Pageable
	@Override
	public NewDTO find(Long id) {
		NewEntity oldNew = new NewEntity();
		Optional<NewEntity> oldNewEntity = newRepository.findById(id);
		if (oldNewEntity.isPresent()) {
			oldNew = oldNewEntity.get();
		}
		NewDTO newDto = newConverter.toDTO(oldNew);
		CategoryEntity oldCategory = new CategoryEntity();
		Optional<CategoryEntity> categoryEntity = categoryRespository.findById(oldNew.getCategory().getId());
		if (categoryEntity.isPresent()) {
			oldCategory = categoryEntity.get();
		}
		newDto.setCategoryCode(oldCategory.getCode());
		return newDto;
	}

	@Override
	public List<NewDTO> findAll() {
		List<NewEntity> listNewEnttity = newRepository.findAll();
		List<NewDTO> listNewDto = new ArrayList<>();
		for (NewEntity newEntity : listNewEnttity) {
			NewDTO newDto = newConverter.toDTO(newEntity);
			CategoryEntity oldCategory = new CategoryEntity();
			Optional<CategoryEntity> categoryEntity = categoryRespository.findById(newEntity.getCategory().getId());
			if (categoryEntity.isPresent()) {
				oldCategory = categoryEntity.get();
			}
			newDto.setCategoryCode(oldCategory.getCode());
			listNewDto.add(newDto);
		}
		return listNewDto;
	}

}
