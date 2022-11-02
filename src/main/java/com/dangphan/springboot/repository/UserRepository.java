package com.dangphan.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dangphan.springboot.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

    UserEntity findByUserName(String userName);
}
