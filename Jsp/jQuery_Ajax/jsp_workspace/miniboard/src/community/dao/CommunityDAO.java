package community.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import community.bean.CommunityDTO;

public class CommunityDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "jspexam";
	String password = "m1234";

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public CommunityDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	//	DB에 입력내용 저장
	public int communityWrite(CommunityDTO communityDTO) {
		int result = 0;
		String sql ="insert into community values " + 
					" (seq_comm.nextval,?,?,?,?,?,sysdate,sysdate)";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, communityDTO.getUser_name());
			pstmt.setString(2, communityDTO.getUser_pwd());
			pstmt.setString(3, communityDTO.getEmail());
			pstmt.setString(4, communityDTO.getSubject());
			pstmt.setString(5, communityDTO.getContent());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return result;
	}
	
	// DB 내용 삭제
	public int communityDelete(int seq, String user_pwd, CommunityDTO communityDTO) {
		int result = 0;
		String sql ="delete from community where seq = ? and user_pwd = ?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, communityDTO.getSeq());
			pstmt.setString(2, communityDTO.getUser_pwd());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
	
		return result;
	}
	// 내용 수정
	public int communityUpdate(CommunityDTO communityDTO) {
		int result = 0;
		String sql = "update community set user_name = ?, email = ?,subject = ?," + 
				" content = ?, edit_date = sysdate" + 
				" where seq =? and user_pwd =?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, communityDTO.getUser_name());
			pstmt.setString(2, communityDTO.getEmail());
			pstmt.setString(3, communityDTO.getSubject());
			pstmt.setString(4, communityDTO.getContent());
			pstmt.setInt(5, communityDTO.getSeq());
			pstmt.setString(6, communityDTO.getUser_pwd());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
		
	}
	
	//	전체 검색
	public List<CommunityDTO> commnityList() {
		List<CommunityDTO> list = new ArrayList<CommunityDTO>();
		String sql = "select * from community order by seq desc";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CommunityDTO dto = new CommunityDTO();
				//list = new ArrayList<CommunityDTO>();
				dto.setContent(rs.getString("content"));
				dto.setEdit_date(rs.getString("edit_date"));
				dto.setEmail(rs.getString("email"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setSeq(rs.getInt("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_pwd(rs.getString("user_pwd"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	// 행 한 개 내용보기
	public CommunityDTO communitySelect(int seq) {
		CommunityDTO dto = null;
		String sql = "select * from community where seq = ?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new CommunityDTO();
				dto.setContent(rs.getString("content"));
				dto.setEdit_date(rs.getString("edit_date"));
				dto.setEmail(rs.getString("email"));
				dto.setReg_date(rs.getString("reg_date"));
				dto.setSeq(rs.getInt("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_pwd(rs.getString("user_pwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	} 
}
