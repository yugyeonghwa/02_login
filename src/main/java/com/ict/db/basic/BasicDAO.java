package com.ict.db.basic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

public class BasicDAO {
	// 실제 사용하는 클래스 : SqlSession
	private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = BasicDBService.getFactory().openSession();
		}
		return ss;
	}
	
	// DB 처리하는 메서드들
	public static int getJoin(BasicVO bvo) {
		int result = 0;
		result = getSession().insert("userMembers.join", bvo);
		ss.commit();
		
		return result;
	}
	
	public static BasicVO getLogin(BasicVO bvo) {
		BasicVO bvo2 = null;
		bvo2 = getSession().selectOne("userMembers.login", bvo);
		return bvo2;
	}
	
	public static BasicVO getDetail(String id) {
		BasicVO bvo2 = null;
		bvo2 = getSession().selectOne("userMembers.detail", id);
		return bvo2;
	}
}
