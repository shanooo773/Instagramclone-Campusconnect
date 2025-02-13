package com.camp.campusconnect.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camp.campusconnect.Service.UserService;
import com.camp.campusconnect.exceptions.UserException;
import com.camp.campusconnect.modal.User;
import com.camp.campusconnect.response.MessageResponse;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;  
	@GetMapping("id/{id}")
	public ResponseEntity<User> findUserByIdHandler(@PathVariable Integer id) throws UserException{
		User user=userService.findUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@GetMapping("username/{username}")
	public ResponseEntity<User> findUserByUserHandler(@PathVariable String username) throws UserException{
		User user=userService.findUserByUsername(username);
	
	return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@PutMapping("follow/{followUserId}")
	public ResponseEntity<MessageResponse> followUserHandler(@PathVariable Integer followUserId) throws UserException{
//		MessageResponse res=userService.FollowUser(followUserId, followUserId)
	return null;
	}
	@PutMapping("/unfollow/{userId}")
	public ResponseEntity<MessageResponse> unFollowUserHandler(@PathVariable Integer userId) throws UserException{
//		MessageResponse res=userService.FollowUser(followUserId, followUserId)
	return null;
	}
	
	@PutMapping("/req")
	public ResponseEntity<MessageResponse> findUserProfileHandler(@RequestHeader("Authorization")String token) throws UserException{
//		MessageResponse res=userService.FollowUser(followUserId, followUserId)
	return null;
	}
	@GetMapping("/m/{userIds}")
	public ResponseEntity<List<User>> findUserByUserIdsHandler(@PathVariable List<Integer> userIds) throws UserException{
		List<User> users=userService.findUserByIds(userIds);
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		 
	}
	//api/users/search?q="query
	@GetMapping("/search")
	public ResponseEntity<List<User>> searchUserHandler(@RequestParam("q") String query) throws UserException{
		List<User> users= userService.searchUser(query);
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
public ResponseEntity<User> updateUserHandler(@RequestHeader("Authorization") String token,@RequestBody User user){

//	User updatedUser=userService.updateUserDetails(user, user);
	
	return null;
	
}
}
