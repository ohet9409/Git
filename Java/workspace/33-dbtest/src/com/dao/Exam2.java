package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class InsertTest {
	// 1. Driver 등록확인
	public InsertTest() {	// 자동으로 1번 호출
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 등록 실패");
//			e.printStackTrace();
		}
	}

	// 2. Connection
	public Connection getConnection() {
		Connection conn = null;
		// localhost = 127.0.0.1(내 pc를 나타낸다.)
		//                      오라클 제품          ip    port sid
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 드라이버가 사용
		String username = "jspexam"; // 계정 이름
		String password = "m1234"; // 계정 비밀번호
		try {
			conn = DriverManager.getConnection(url, username, password);	// 오라클에 접속
			System.out.println("접속 성공");
		} catch (SQLException e) {
			System.out.println("접속 실패");
//			e.printStackTrace();
		}
		return conn;
	}

	// 3. SQL 작업처리
	public void insertArticle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("키 입력 : ");
		double height = sc.nextDouble();
		// DB 처리
		Connection conn = getConnection();
		PreparedStatement pstmt = null;		// sql문을 쉽게 사용하고 오라클에 요청하는 용도
		int su = 0;
		String sql = "insert into dbtest values (?, ?, ?, sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);	// 1번 부터 시작
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			su = pstmt.executeUpdate(); // 실행 : 처리된 데이터 갯수가 리턴됨
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {	// 접속을 끊는 코드
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(su + "개의 행이 만들어 졌습니다");
	}
}

public class Exam2 {

	public static void main(String[] args) {
		InsertTest insertTest = new InsertTest();
		insertTest.insertArticle();
	}

}
