package com.virtusa.mrviewer.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.mrviewer.system.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
}
