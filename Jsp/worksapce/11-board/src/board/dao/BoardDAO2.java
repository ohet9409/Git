package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.bean.BoardDTO;
import member.bean.MemberDTO;

public class BoardDAO2 {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "jspexam";
	String password = "m1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 1. Driver Loading
	public BoardDAO2() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 2. Connection
	public Connection getConnection() {

		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	// 5. 접속 종료
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// 데이터 추가
	public int boardWrite(BoardDTO boardDTO) {
		int su=0;
		conn=getConnection();
		String sql = "insert into board values (seq_board.nextval, ?, ?,?,?,0,sysdate)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getId());
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getSubject());
			pstmt.setString(4, boardDTO.getContent());
			su=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
}
