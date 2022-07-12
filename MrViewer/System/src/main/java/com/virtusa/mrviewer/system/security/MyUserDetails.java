package com.virtusa.mrviewer.system.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.virtusa.mrviewer.system.model.Role;
import com.virtusa.mrviewer.system.model.User;

public class MyUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	private String username;
	private String mobileNumber;
	private boolean active;
	private String role;
	
	public MyUserDetails(User user) {
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.username = user.getUsername();
		this.mobileNumber =user.getMobileNumber();
		this.active = user.isActive();
		this.role = user.getRole();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
