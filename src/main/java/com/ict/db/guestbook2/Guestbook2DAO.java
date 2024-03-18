package com.ict.db.guestbook2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Guestbook2DAO {
	private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = Guestbook2DBService.getFactory().openSession();
		}
		return ss;
	}
	
	// 리스트
	public static List<Guestbook2VO> getList(){
		try {
			List<Guestbook2VO> list = null;
			list = getSession().selectList("guestbook2.list");
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// 상세보기
	public static Guestbook2VO getOneList(String idx) {
		try {
			Guestbook2VO g2vo = null;
			g2vo = getSession().selectOne("guestbook2.detail", idx);
			return g2vo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	// 삽입
	public static int getInsert(Guestbook2VO g2vo) {
		try {
			int result = 0;
			result = getSession().insert("guestbook2.insert", g2vo);
			ss.commit();
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	// 삭제
	public static int getDelete(String idx) {
		try {
			int result = 0;
			result = getSession().delete("guestbook2.delete", idx);
			ss.commit();
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	// 수정
	public static int getUpdate(Guestbook2VO g2vo) {
		try {
			int result = 0;
			result = getSession().update("guestbook2.update", g2vo);
			ss.commit();
			return result;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
