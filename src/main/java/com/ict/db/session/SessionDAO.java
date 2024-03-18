package com.ict.db.session;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

public class SessionDAO {
	// 실제 사용하는 클래스 : SqlSession
	private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = SessionDBService.getFactory().openSession();
		}
		return ss;
	}
	
	// DB 처리하는 메서드들
	public static int getJoin(SessionVO svo) {
		int result = 0;
		result = getSession().insert("sessionUser.s_join", svo);
		ss.commit();
		
		return result;
	}
	
	public static SessionVO getLogin(SessionVO svo) {
		SessionVO svo2 = null;
		svo2 = getSession().selectOne("sessionUser.s_login", svo);
		return svo2;
	}
	
	public static SessionVO getDetail(String id) {
		SessionVO svo = null;
		svo = getSession().selectOne("sessionUser.s_detail", id);
		return svo;
	}
}
