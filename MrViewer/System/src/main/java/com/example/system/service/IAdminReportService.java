package com.example.system.service;

import javax.servlet.http.HttpServletResponse;

public interface IAdminReportService {
	String generateMovieReport(HttpServletResponse response);

	String generateUserReport(HttpServletResponse response);

	String generateLocaleReport(HttpServletResponse response);

}
