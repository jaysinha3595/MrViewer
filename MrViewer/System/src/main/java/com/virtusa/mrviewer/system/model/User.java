package com.virtusa.mrviewer.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.virtusa.mrviewer.system.dto.UserDTO;

@Entity
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;

	@Email
	@NotBlank(message = "Email must not be blank")
	@Column(unique = true)
	private String email;

	@NotBlank(message = "Password must not be blank")
	private String password;

	@NotBlank(message = "Username must not be blank")
	private String username;

	@NotBlank(message = "Mobile Number must not be blank")
	@Pattern(regexp = "[\\d]{10}", message = "Must be a valid mobile number")
	private String mobileNumber;

	private boolean active = true;

	private String role = "ROLE_USER";
	private Gender gender = null;

	public User() {
		super();
	}

	public User(UserDTO dto) {
		email = dto.getEmail();
		password = dto.getPassword();
		username = dto.getUsername();
		mobileNumber = dto.getMobileNumber();
		gender = dto.getGender();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
