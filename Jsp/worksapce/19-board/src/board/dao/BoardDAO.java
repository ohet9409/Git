package board.dao;

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

import board.bean.BoardBean;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	// Datasource 얻어오기
	// 커넥션풀 설정
	public BoardDAO() {
			try {
				Context context = new InitialContext();
				ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}

	public void close() {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		}
	// 데이터 저장
	public int insertArticle(BoardBean bean) {
		int su=0;
		String sql = "insert into board2 values (seq_num.nextval, ?,?,?,?," + 
				" ?,seq_num.currval,0,0,0,sysdate)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getBoard_name());
			pstmt.setString(2, bean.getBoard_pass());
			pstmt.setString(3, bean.getBoard_subject());
			pstmt.setString(4, bean.getBoard_content());
			pstmt.setString(5, bean.getBoard_file());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	// 데이터 검색
	public List<BoardBean> list() {
		List<BoardBean> list = new ArrayList<BoardBean>();
		String sql = "select*from board2";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				BoardBean bean = new BoardBean();
				bean.setBoard_name(rs.getString("board_name"));
				bean.setBoard_num(rs.getInt("board_num"));
				bean.setBoard_subject(rs.getString("board_subject"));
				bean.setBoard_date(rs.getString("board_date"));
				bean.setBoard_readcount(rs.getInt("board_readcount"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
}
