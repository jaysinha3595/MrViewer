//package com.example.system.service;
//
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.example.system.dto.AuthDTO;
//import com.example.system.dto.UserDTO;
//import com.example.system.event.RegistrationOTPExpiredEvent;
//import com.example.system.model.HoldUsers;
//import com.example.system.model.User;
//import com.example.system.repository.AuthRepository;
//import com.example.system.repository.HoldUserRepository;
//
//@Service
//public class AuthService implements IAuthService {
//
//	@Autowired
//	private HoldUserRepository holdUserRepository;
//
//	@Autowired
//	AuthRepository authRepository;
//
//	@Autowired
//	ApplicationEventPublisher eventPublisher;
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Override
//	public void holdUserRegistration(HoldUsers holdUsers) {
//		Random random = new Random();
//		String otp = String.format("%04d", random.nextInt(10000));
//		holdUsers.setRegistrationOtp(otp);
//		holdUserRepository.save(holdUsers);
//		authRepository.save(new User(holdUsers));
//
////		try {
////			Thread.sleep(10000);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		eventPublisher.publishEvent(new RegistrationOTPExpiredEvent(holdUsers.getUsername()));
//
//	}
//
//	@Override
//	public boolean signup(HoldUsers holdUsers) {
//		if (authRepository.findByEmail(holdUsers.getEmail()) == null) {
//			if (validateSignupData(holdUsers)) {
//				holdUsers.setPassword(passwordEncoder.encode(holdUsers.getPassword()));
//				authRepository.save(new User(holdUsers));
//			}
//
//			else
//				throw new RuntimeException("Password must be atleast 8 characters.");
//			return true;
//		}
//		throw new RuntimeException("User already exists with email " + holdUsers.getEmail());
//	}
//
//	private boolean validateSignupData(HoldUsers holdUsers) {
//		if (holdUsers.getPassword().length() < 8) {
//			return false;
//		}
//		return true;
//	}
//
//	@Override
//	public boolean login(HoldUsers holdUsers) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//}
