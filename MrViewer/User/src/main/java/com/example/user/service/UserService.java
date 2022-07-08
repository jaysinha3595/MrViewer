package com.example.user.service;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;

public class UserService {
	private final UserRepository userrepository;
	
	public UserService(UserRepository userrepo) {
		this.userrepository = userrepo;
	}
	
	public User updateUser(User user) {
		return userrepository.save(user);
	}
}
