package com.camp.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.camp.campusconnect.Service.UserService;
import com.camp.campusconnect.exceptions.UserException;
import com.camp.campusconnect.modal.User;

@RestController
public class Authcontroller {
	@Autowired
private UserService userService;
	@PostMapping("/signup")
public ResponseEntity<User> registerUserHandler(@RequestBody User user) throws UserException{
	User createdUser=userService.registerUser(user);
	return new ResponseEntity<User>(createdUser,HttpStatus.OK);
}
}
