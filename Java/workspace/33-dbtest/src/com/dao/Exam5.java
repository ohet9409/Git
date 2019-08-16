package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class DeleteTest {
	// 1. Driver 등록 확인
	public DeleteTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {

//			e.printStackTrace();
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
	public void deleteArticle() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 이름 입력 : ");
		String name = scanner.next();
		// DB 처리
		String sql = "delete dbtest where name=?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			su = pstmt.executeUpdate(); // 데이터 삭제 요청, 데이터 갯수 받아옴
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
		System.out.println(su + "개의 행이 삭제되었습니다.");
	}
}

public class Exam5 {

	public static void main(String[] args) {
		DeleteTest deleteTest = new DeleteTest();
		deleteTest.deleteArticle();

	}

}
