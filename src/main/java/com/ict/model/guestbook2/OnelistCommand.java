package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guestbook2DAO;
import com.ict.db.guestbook2.Guestbook2VO;
import com.ict.model.basic.Command;

public class OnelistCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String idx = request.getParameter("idx");
		Guestbook2VO g2vo = Guestbook2DAO.getOneList(idx);
		
		if (g2vo != null) {
			request.setAttribute("g2vo", g2vo);
			return "view/guestbook2/onelist.jsp";
		} else {
			return "view/guestbook2/error.jsp";
		}
		
	}

}
