package member.dao;
/* JDBC 작업단계 
 * 1. Driver Loading
 * 2. Connection
 * 3. SQL 작업처리
 * 4. 반환값 처리
 * 5. 접속 종료
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.bean.MemberDTO;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "jspexam";
	String password = "m1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 1. Driver Loading
	public MemberDAO() {
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

	/*
	 * 3. SQL 작업처리 4. 반환값 처리
	 */
	// 데이터 저장
	public int write(MemberDTO memberDTO) {
		int su =0;
		String sql ="INSERT into MEMBER VALUES(?,?,?,?,?,?,?,?,?,?,sysdate)";
		conn = getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getAddr());
			su = pstmt.executeUpdate();	// 요청, 응답
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	// id 일치 데이터 검색
	public String login(String id, String pwd) {
		String name= null;
		String sql ="SELECT * FROM MEMBER where id=? and pwd=?";
		conn = getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery(); // 서버에 sql 처리요청, 처리결과를 ResultSet에 저장
			if(rs.next()) {		// ResultSet에 저장된 데이터 꺼내기, 성공했으면 true, 실패하면 false
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return name;
	}
	// ID 데이터 검색
	public boolean isExistId(String id) {
		boolean exist = false;
		String sql = "SELECT * from MEMBER where id =?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();	//요청, 응답
			if (rs.next()) {	// 일치하는 ID가 존재할 때
				exist=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return exist;
	}
	// 데이터 수정
	public int modify() {
		
		return 0;
	}

	// 데이터 삭제
	public int delete(String id) {
		int su=0;
		conn=getConnection();
		String sql = "delete member where id = ?";
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, id);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	

}
