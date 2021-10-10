package com.servme.todo.todoapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.servme.todo.todoapplication.entity.User;
import com.servme.todo.todoapplication.repository.UserRepository;

@Service
public class TodoService {
	
	@Autowired
	UserRepository userRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User getUser(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public String deleteUser(Long id) {
		userRepository.deleteById(id);
		return "delete successfull!";
	}

	public User editUser(User user) {
		User existingDetails = userRepository.findById(user.getUserId()).orElse(null);
		if(existingDetails!=null) {
			existingDetails.setFirstName(user.getFirstName());
			existingDetails.setLastName(user.getLastName());
			existingDetails.setBirthday(user.getBirthday());
			existingDetails.setEmail(user.getEmail());
			existingDetails.setGender(user.getGender());
			existingDetails.setMobileNumber(user.getMobileNumber());
		}
		return existingDetails;
	}

}
