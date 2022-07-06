package com.example.system.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.system.model.Gender;

public class UserDTO {

	@NotNull
	@Email
	private String email;

	@NotBlank
	private String password;

	@NotBlank(message = "Username is mandatory")
	private String username;

	@NotBlank(message = "Mobile number is mandatory")
	@Size(min = 10, max = 10)
	@Pattern(regexp = "[\\d]{10}", message = "Must be a valid mobile number")
	private String mobileNumber;

	private Gender gender;

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
