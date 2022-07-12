package com.virtusa.mrviewer.system.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.virtusa.mrviewer.system.model.Gender;

public class UserDTO {
	@Email
	@NotBlank(message = "Email must not be blank")
	private String email;
	
	@NotBlank(message = "Password must not be blank")
	@Size(min = 8, message = "Password must be atleast 8 characters")
	private String password;
	
	@NotBlank(message = "Username must not be blank")
	private String username;
	
	@Pattern(regexp = "[\\d]{10}", message = "Mobile number Must be a 10 digit numeric value")
	@NotBlank(message = "Mobile Number must not be blank")
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
