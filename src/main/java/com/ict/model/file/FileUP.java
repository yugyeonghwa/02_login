package com.ict.model.file;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileUP {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 실제 저장위치를 얻어내자
			String path = request.getServletContext().getRealPath("upload");
					
			// 파일 업로드를 하면 request 대신 사용하는 클래스
			MultipartRequest mr = 
					new MultipartRequest(request, 
							path, 
							100*1024*1024, 	// 100MB, 업로드 용량 제한
							"utf-8",		// 한글처리
							// 업로드 위치에 같은 이름의 파일이 있으면 파일이름 뒤에 숫자가 붙는다.
							new DefaultFileRenamePolicy()	
							);
			
			// request.getParameter("name") => null, mr 사용
			String name = mr.getParameter("name");
			// 사용자가 파일을 올릴 때 이름
			// String f_name = mr.getOriginalFileName(name);
			// 서버가 저장할 당시 이름
			String f_name = mr.getFilesystemName("f_name");
			
			String contentType = mr.getContentType(f_name);
			
			File file = new File(path, f_name);
			long f_size = file.length();
			long f_last = file.lastModified();
			
			SimpleDateFormat day = 
					new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
			String f_last2 = day.format(f_last);
			
//			System.out.println(name);
//			System.out.println(f_name);
//			System.out.println(contentType);
//			System.out.println(f_size);
//			System.out.println(f_last);
			
			request.setAttribute("name", name);
			request.setAttribute("f_name", f_name);
			request.setAttribute("contentType", contentType);
			request.setAttribute("f_size", f_size);
			request.setAttribute("f_last", f_last);
			request.setAttribute("f_last2", f_last2);
			
			return "view/fileup_down/FileUp_result.jsp";
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
