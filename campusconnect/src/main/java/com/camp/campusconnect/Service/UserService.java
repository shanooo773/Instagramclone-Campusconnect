package com.camp.campusconnect.Service;

import java.util.*;


import com.camp.campusconnect.exceptions.UserException;
import com.camp.campusconnect.modal.User;

public interface UserService {

	public User registerUser(User user) throws UserException;
	public User findUserById(Integer userId) throws UserException;
	public User FindUSerProfile(String token) throws UserException;
	public User findUserByUsername(String username) throws UserException;
	public String FollowUser(Integer reqUserId,Integer followUserId) throws UserException;
	public String unFollowUser(Integer reqUserId,Integer followUserId) throws UserException;
	
	public List<User> findUserByIds(List<Integer>userIds) throws UserException;
	
	public List<User> searchUser(String query) throws UserException;
	
	public User updateUserDetails(User updatedUser,User existingUser) throws UserException;
	
	
	
}
