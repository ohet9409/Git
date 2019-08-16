package score.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.org.apache.regexp.internal.recompile;

import score.dto.ScoreDTO;

public class ScoreDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	// 커넥션풀 설정
	public ScoreDAO() {
			try {
				Context context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
	public void close() {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	// 성적 입력
	public int inputScore(ScoreDTO dto) {
		int su =0;
		String sql = "insert into score2 VALUES(?,?,?,?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getHakbun());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			pstmt.setInt(6, dto.getHis());
			pstmt.setInt(7, dto.getTotal());
			pstmt.setDouble(8, dto.getAvg());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	// 최근 글 10개 출력
	public List<ScoreDTO> list(int startNum, int endNum) {
		List<ScoreDTO> list = new ArrayList<ScoreDTO>();
		String sql ="select hakbun, name, kor, eng, mat,his, total, avg " + 
				" from (select rownum rn,tt.*from(select * from score2 order by hakbun asc)tt) where rn>=? and rn<=?";
		try {
			conn = ds.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ScoreDTO dto = new ScoreDTO();
				dto.setHakbun(rs.getString("hakbun"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setHis(rs.getInt("his"));
				dto.setTotal(rs.getInt("total"));
				dto.setAvg(rs.getInt("avg"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	// 총 글수 구하기
	public int count() {
		int count =0;
		String sql = "select count(*) as count from score2";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return count;
	}
}
