package com.ict.model.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.basic.Command;

public class SessionLoginCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
			
		return "view/session/loginForm.jsp";
	}

}
