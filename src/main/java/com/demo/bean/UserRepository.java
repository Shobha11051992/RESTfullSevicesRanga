package com.demo.bean;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public interface UserRepository extends JpaRepository<Users, Integer> {

//	List<Users> findAll();
//	

}
