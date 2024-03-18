package com.ict.model.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	// 요청사항을 처리할 Model 들이 사용할 메서드를 가지고 있음
	public String exec(HttpServletRequest request, HttpServletResponse response);
	
}
