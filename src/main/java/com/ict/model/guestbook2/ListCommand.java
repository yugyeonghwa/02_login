package com.ict.model.guestbook2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guestbook2DAO;
import com.ict.db.guestbook2.Guestbook2VO;
import com.ict.model.basic.Command;

public class ListCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 전체 목록 가져오기
		List<Guestbook2VO> list = Guestbook2DAO.getList();
		request.setAttribute("list", list);
		
		return "view/guestbook2/list.jsp";
	}

}
