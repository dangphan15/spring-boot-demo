package com.dangphan.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dangphan.springboot.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	CategoryEntity findOneByCode(String code);
	
}
