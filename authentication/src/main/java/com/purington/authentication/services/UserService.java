package com.purington.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.purington.authentication.models.LoginUser;
import com.purington.authentication.models.User;
import com.purington.authentication.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User register(User newUser, BindingResult result) {
		
		//check if email is in db
		if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "unique", "Email is already in use");
		}
		//make sure passwords match
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "Passwords must match");
			
		}
		//if there are errors return null...final check
		if(result.hasErrors())
			return null;
		
		//hash and set password, save user into db
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		
		
		return userRepository.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		//check for errors
		if(result.hasErrors()) {
			return null;
		}
		//check if email is in db
		Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "unique", "Invalid Credentials");
			
			return null;
		}
		
		//check if password matches password in db
		User user = potentialUser.get(); //get user object from optional user
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "matches", "Invalid Credentials");
		}
		
		return user;
	}
	
	//Read User
	
	public User getOne(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	//Update and Delete for later
}
