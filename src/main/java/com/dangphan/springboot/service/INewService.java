package com.dangphan.springboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dangphan.springboot.dto.NewDTO;

public interface INewService {

	NewDTO save(NewDTO newDto);

	NewDTO update(NewDTO newDto);
	
	void delete(long[] ids);
	
	List<NewDTO> findAll(Pageable pageable);
	
	int totalItem();

	NewDTO find(Long id);
	
	List<NewDTO> findAll();
}
