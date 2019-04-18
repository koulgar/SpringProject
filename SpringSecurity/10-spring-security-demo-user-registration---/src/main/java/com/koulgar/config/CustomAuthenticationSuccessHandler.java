package com.koulgar.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koulgar.entitiy.User;
import com.koulgar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		System.out.println("\n\nIn customAuthenticationSuccessHandler\n\n");

		String username = authentication.getName();

		System.out.println("username=" + username);

		User theUser = userService.findByUserName(username);

		// now place in the session
		HttpSession session = request.getSession();
		session.setAttribute("user", theUser);

		// forward to home page
		response.sendRedirect(request.getContextPath() + "/");
	}

}
