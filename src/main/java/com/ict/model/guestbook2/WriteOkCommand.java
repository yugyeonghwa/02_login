package com.ict.model.guestbook2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guestbook2DAO;
import com.ict.db.guestbook2.Guestbook2VO;
import com.ict.model.basic.Command;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteOkCommand implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 실제 저장 위치
			String path = request.getServletContext().getRealPath("upload");
			
			MultipartRequest mr = 
					new MultipartRequest(request, path, 
							500*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			Guestbook2VO g2vo = new Guestbook2VO();
			g2vo.setName(mr.getParameter("name"));
			g2vo.setSubject(mr.getParameter("subject"));
			g2vo.setContent(mr.getParameter("content"));
			g2vo.setEmail(mr.getParameter("email"));
			g2vo.setPwd(mr.getParameter("pwd"));
			
			// 첨부파일이 있을 때와 없을 때를 구분하자.
			if(mr.getFile("f_name") != null) {
				g2vo.setF_name(mr.getFilesystemName("f_name"));
			} else {
				g2vo.setF_name("");
			}
			
			int result = Guestbook2DAO.getInsert(g2vo);
			if (result > 0) {
				return "Guestbook2Controller?cmd=list";
				
			}
			return "view/guestbook2/error.jsp";
		} catch (Exception e) {
			System.out.println(e);
			return "view/guestbook2/error.jsp";
		}
	}

}
