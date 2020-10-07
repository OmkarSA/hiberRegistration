package com.example.hiberRegistration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hiberRegistration.model.User;
import com.example.hiberRegistration.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;

	// Getting all the users
	public List<User> getAllUser() {
		List<User> users = userRepo.findAll();

		if (users.size() > 0)
			return users;
		else
			return null;
	}

	// Getting user by their id
	public User getUser(Integer id) {
		try {
			Optional<User> user = userRepo.findById(id);
			return user.get();
		} catch (Exception e) {
			return null;
		}

	}

	// Adding user into the database
	public String addUser(User user) {
		User user1 = userRepo.save(user);
		return "User added into the database and it's id is " + user1.getId();
	}

	// Deleting user from database
	public String removeUser(Integer id) {
		try {
			userRepo.deleteById(id);
		} catch (Exception e) {
			return "User is already removed from database";
		}
		return "User is removed from database";
	}
}
