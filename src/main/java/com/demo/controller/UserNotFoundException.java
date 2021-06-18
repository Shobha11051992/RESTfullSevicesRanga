package com.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //if we not taken this we will get  "status": 500, "error": "Internal Server Error", 
//  by using we get the proper response 404 bcz this resource not found
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
	}

	

}
