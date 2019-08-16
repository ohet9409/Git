package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolDAO {
	public SchoolDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이브 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 연결 실패");
			e.printStackTrace();
		}
	}

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

	// 입력
	public int insertArticle(SchoolDTO dto) {
		int su = 0;
		String sql = "insert into school values (?,?,?) ";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getValue());
			pstmt.setInt(3, dto.getCode());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return su;
	}
	// 삭제
	public int deleteArticle(String name) {
		int su=0;
		String sql = "delete from school where name = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			su=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return su;
	}
	// 검색
	public List<SchoolDTO> selectA(String name) {
		List<SchoolDTO> list=null;
		String sql = "select * from school where name like ?";
		Connection conn =getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				SchoolDTO dto = new SchoolDTO();
				list= new ArrayList<SchoolDTO>();
				dto.setName(rs.getString("name"));
				dto.setValue(rs.getString("value"));
				dto.setCode(rs.getInt("code"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<SchoolDTO> selectB(){
		List<SchoolDTO> list = null;
		String sql = "select * from school";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SchoolDTO dto = new SchoolDTO();
				list = new ArrayList<SchoolDTO>();
				dto.setName(rs.getString("name"));
				dto.setValue(rs.getString("value"));
				dto.setCode(rs.getInt("code"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
