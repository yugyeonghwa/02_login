package com.ict.db.guestbook2;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Guestbook2DBService {
	static private SqlSessionFactory factory;
	static String resource = "com/ict/db/guestbook2/guestbook2_config.xml";
	
	static {
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
