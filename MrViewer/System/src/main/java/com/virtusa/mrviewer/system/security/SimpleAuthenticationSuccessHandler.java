package com.virtusa.mrviewer.system.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
		
		if(userDetails.getRole().equals("ROLE_ADMIN")) {
			response.sendRedirect("/admin/home");
		}else {
			response.sendRedirect("/user/home");
		}

	}

}
