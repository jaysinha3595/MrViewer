package com.virtusa.mrviewer.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.virtusa.mrviewer.system.dto.UserDTO;
import com.virtusa.mrviewer.system.event.UserRegistrationEvent;
import com.virtusa.mrviewer.system.model.User;
import com.virtusa.mrviewer.system.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Override
	public void addUser(UserDTO userDTO) {
		if(!userRepository.existsByEmail(userDTO.getEmail())) {
			userDTO.setPassword(encoder.encode(userDTO.getPassword()));
			userRepository.save(new User(userDTO));
			eventPublisher.publishEvent(new UserRegistrationEvent(userDTO.getUsername(), userDTO.getEmail()));
		}else {
			throw new RuntimeException("User already exists by email: "+userDTO.getEmail());
		}
	}

}
