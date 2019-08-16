package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SelectTest{
	// 1. Driver 등록하기
	public SelectTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	// 2. Connection
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jspexam";
		String password ="m1234";
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	// 3. SQL 작업처리
	public void selectArticle() {
		// DB 처리
		String sql="select * from dbtest order by age";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();	// 검색 결과를 요청해서 rs에 저장
			while (rs.next()) {		// rs.next(): 데이터가 있으면 true, 없으면 false -> 데이터가 있으면 한줄씩 가져온다.
				String name = rs.getString("name");
				int age = rs.getInt("age");
				double height = rs.getDouble("height");
				String logtime = rs.getString("logtime");
				System.out.println(name + "\t" + age + "\t" + height + "\t" + logtime);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
				try {
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

public class Exam3 {

	public static void main(String[] args) {
		SelectTest selectTest = new SelectTest();
		selectTest.selectArticle();
	}

}
