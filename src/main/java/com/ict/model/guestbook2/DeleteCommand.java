package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.basic.Command;

public class DeleteCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		String pwd = request.getParameter("pwd");
		
		request.setAttribute("idx", idx);
		request.setAttribute("pwd", pwd);
		
		
		return "view/guestbook2/delete.jsp";
	}

}
