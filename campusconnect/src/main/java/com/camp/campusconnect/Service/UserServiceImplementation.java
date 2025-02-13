package com.camp.campusconnect.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.campusconnect.repository.UserRepository;
import com.camp.campusconnect.dto.UserDto;
import com.camp.campusconnect.exceptions.UserException;
import com.camp.campusconnect.modal.User;

import jakarta.transaction.Transactional;
@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Override
	
	public User registerUser(User user) throws UserException {
	    try {
	        Optional<User> isEmailExist = userRepository.findByEmail(user.getEmail());
	        if (isEmailExist.isPresent()) {
	            throw new UserException("Email already exists.");
	        }
	        Optional<User> isUsernameExist = userRepository.findByUsername(user.getUsername());
	        if (isUsernameExist.isPresent()) {
	            throw new UserException("Username is already taken.");
	        }
	        if (user.getEmail() == null || user.getPassword() == null || 
	            user.getUsername() == null || user.getName() == null) {
	            throw new UserException("All fields are required.");
	        }

	        User newUser = new User();
	        newUser.setEmail(user.getEmail());
	        newUser.setPassword(user.getPassword());
	        newUser.setUsername(user.getUsername());
	        newUser.setName(user.getName());

	        return userRepository.save(newUser);
	    } catch (Exception e) {
	        throw new UserException("Error occurred while registering user: " + e.getMessage());
	    }
	}

	
	
	@Override
	public User findUserById(Integer userId) throws UserException {
	    try {
	        return userRepository.findById(userId)
	                             .orElseThrow(() -> new UserException("User not found with id: " + userId));
	    } catch (Exception e) {
	        throw new UserException("Error occurred while fetching user: " + e.getMessage());
	    }
	}


	@Override
	public User FindUSerProfile(String token) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUsername(String username) throws UserException {
	    try {
	        return userRepository.findByUsername(username)
	                             .orElseThrow(() -> new UserException("User not found with username: " + username));
	    } catch (Exception e) {
	        throw new UserException("Error occurred while fetching user by username: " + e.getMessage());
	    }
	}

	@Override
	@Transactional
	public String FollowUser(Integer reqUserId, Integer followUserId) throws UserException {
	    try {
	        // Fetching users by ID
	        User reqUser = findUserById(reqUserId);
	        User followUser = findUserById(followUserId);

	        // Creating a UserDto for follower
	        UserDto follower = new UserDto();
	        follower.setEmail(reqUser.getEmail());
	        follower.setId(reqUser.getId());
	        follower.setName(reqUser.getName());
	        follower.setUserImage(reqUser.getImage());
	        follower.setUsername(reqUser.getUsername());

	        // Creating a UserDto for following
	        UserDto following = new UserDto();
	        following.setEmail(followUser.getEmail());
	        following.setId(followUser.getId());
	        following.setName(followUser.getName());
	        following.setUserImage(followUser.getImage());
	        following.setUsername(followUser.getUsername());

	        // Updating follower and following lists
	        reqUser.getFollowing().add(following);
	        followUser.getFollower().add(follower);

	        // Persisting changes
	        userRepository.save(followUser);
	        userRepository.save(reqUser);

	        return "You are now following " + followUser.getUsername();
	    } catch (Exception e) {
	        throw new UserException("Error occurred while following user: " + e.getMessage());
	    }
	}



	
	@Override
	public List<User> findUserByIds(List<Integer> userIds) throws UserException {
	    try {
	        // Fetch users from the repository
	        List<User> users = userRepository.findByUserIds(userIds);
	        
	        // Check if the result is empty
	        if (users == null || users.isEmpty()) {
	            throw new UserException("No users found for the provided IDs: " + userIds);
	        }
	        
	        return users;
	    } catch (Exception e) {
	        // Catch and wrap any unexpected exception
	        throw new UserException("Error occurred while fetching users by IDs: " + e.getMessage());
	    }
	}

	@Override
	@Transactional
	public String unFollowUser(Integer reqUserId, Integer followUserId) throws UserException {
	    try {
	        // Fetching users by ID
	        User reqUser = findUserById(reqUserId);
	        User followUser = findUserById(followUserId);

	        // Creating a UserDto for follower
	        UserDto follower = new UserDto();
	        follower.setEmail(reqUser.getEmail());
	        follower.setId(reqUser.getId());
	        follower.setName(reqUser.getName());
	        follower.setUserImage(reqUser.getImage());
	        follower.setUsername(reqUser.getUsername());

	        // Creating a UserDto for following
	        UserDto following = new UserDto();
	        following.setEmail(followUser.getEmail());
	        following.setId(followUser.getId());
	        following.setName(followUser.getName());
	        following.setUserImage(followUser.getImage());
	        following.setUsername(followUser.getUsername());

	        // Updating follower and following lists
	        reqUser.getFollowing().removeIf(f -> f.getId().equals(followUser.getId()));
	        followUser.getFollower().removeIf(f -> f.getId().equals(reqUser.getId()));

	        // Persisting changes
	        userRepository.save(followUser);
	        userRepository.save(reqUser);

	        return "You have unfollowed " + followUser.getUsername();
	    } catch (Exception e) {
	        throw new UserException("Error occurred while unfollowing user: " + e.getMessage());
	    }
	}
                     
	@Override
	public List<User> searchUser(String query) throws UserException {
	    try {
	        List<User> users = userRepository.findByQuery(query);
	        if (users.isEmpty()) {
	            throw new UserException("No users found for query: " + query);
	        }
	        return users;
	    } catch (Exception e) {
	        throw new UserException("Error occurred while searching for users: " + e.getMessage());
	    }
	}


	@Override
	public User updateUserDetails(User updatedUser, User existingUser) throws UserException {
		if(updatedUser.getEmail()!=null) {
			existingUser.setEmail(updatedUser.getEmail());
		}
		if(updatedUser.getBio()!=null) {
			existingUser.setBio(updatedUser.getBio());
		}
		if(updatedUser.getName()!=null) {
			existingUser.setName(updatedUser.getName());
		}
		if(updatedUser.getUsername()!=null) {
			existingUser.setUsername(updatedUser.getUsername());
		}
		if(updatedUser.getMobile()!=null) {
			existingUser.setMobile(updatedUser.getMobile());
		}
		if(updatedUser.getGender()!=null) {
			existingUser.setGender(updatedUser.getGender());
		}
		if(updatedUser.getWebsite()!=null) {
			existingUser.setWebsite(updatedUser.getWebsite());
		}
		if(updatedUser.getImage()!=null) {
			existingUser.setImage(updatedUser.getImage());
		}
		if(updatedUser.getId().equals(existingUser.getId())) {
			return userRepository.save(existingUser);
		}
		throw new UserException("you cant update this user");
	}

}
