package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guestbook2DAO;
import com.ict.model.basic.Command;

public class DeleteOkCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		int result = Guestbook2DAO.getDelete(idx);
		if (result>0) {
			// 이미지 삭제하기 (숙제)
			return "Guestbook2Controller?cmd=list";
		} else {
			return "view/guestbook2/error.jsp";
		}
		
	}

}
