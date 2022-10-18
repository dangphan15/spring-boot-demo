package com.dangphan.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dangphan.springboot.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {

}
