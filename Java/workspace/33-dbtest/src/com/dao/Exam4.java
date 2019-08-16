package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class UpdateTest {
	// 1. Driver 등록확인
	public UpdateTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 2. Connection
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "jspexam";
		String password = "m1234";
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	// 3. SQL 작업 처리
	public void updateArticle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 이름 입력 : ");
		String name = sc.next();
		// DB 처리
		String sql = "update dbtest set age=age+1 where name=?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
		System.out.println(su + "개의 행이 수정되었습니다.");
	}
}

public class Exam4 {

	public static void main(String[] args) {
		UpdateTest updateTest = new UpdateTest();
		updateTest.updateArticle();
		
	}

}
