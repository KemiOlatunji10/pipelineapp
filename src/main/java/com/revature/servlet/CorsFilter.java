package com.revature.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {
	/*
	 * This class is a servlet filer created to handle CORS (Cross orgin resource sharing)
	 * errors which occur when sending a request to this aaplicatuin from an application depolyed at another port 
	 * (ie out angular app)
	 * 
	 * A servlet fuilter is an obkect that performs filtering tasks on either ...
	 */

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		System.out.println("Incoming " + httpRequest.getMethod() + " request at " + httpRequest.getRequestURI());

		httpResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		httpResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, HEAD, OPTIONS, PUT, DELETE");
		httpResponse.addHeader("Access-Control-Allow-Headers", "Content-Type");

		if (httpRequest.getMethod().equals("OPTIONS"))
			httpResponse.setStatus(202);

		// What filters on the request to the Servlet
		chain.doFilter(httpRequest, httpResponse);

	}

	@Override
	public void destroy() {

	}

}
