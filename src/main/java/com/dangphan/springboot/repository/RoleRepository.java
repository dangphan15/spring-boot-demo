package com.dangphan.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dangphan.springboot.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	RoleEntity findByName(String name);
}
