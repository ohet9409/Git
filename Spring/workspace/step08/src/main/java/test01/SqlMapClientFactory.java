package test01;
// MyBatis 관리 클래스인 SqlSession 만들기

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.Resource;


public class SqlMapClientFactory {
	private static SqlSessionFactory factory = null;
	
	// static 초기화 : 프로그램 시작될 때, 초기화하기
	static {
		String resource = "mybatis-config.xml";
		Reader reader;
		try {
			reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public static SqlSession getSqlMapClientInstance() {
		return factory.openSession();
	}
}
