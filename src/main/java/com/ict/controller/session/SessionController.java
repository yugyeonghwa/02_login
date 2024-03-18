package com.ict.controller.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.basic.Command;
import com.ict.model.session.SessionJoinCommand;
import com.ict.model.session.SessionJoinOkCommand;
import com.ict.model.session.SessionLoginCommand;
import com.ict.model.session.SessionLoginOkCommand;
import com.ict.model.session.SessionLogoutCommand;
import com.ict.model.session.SessionProfileCommand;
import com.ict.model.session.SessionProfileOkCommand;

@WebServlet("/SessionController")
public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		Command comm = null;
		
		switch (cmd) {
			case "s_join" : comm = new SessionJoinCommand(); break;
			case "s_join_ok" : comm = new SessionJoinOkCommand(); break;
			case "s_login_ok" : comm = new SessionLoginOkCommand(); break;
			case "s_login" : comm = new SessionLoginCommand(); break;
			case "s_profile" : comm = new SessionProfileCommand(); break;
			case "s_profile_ok" : comm = new SessionProfileOkCommand(); break;
			case "s_logout" : comm = new SessionLogoutCommand(); break;
		}
		
		String path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}
}