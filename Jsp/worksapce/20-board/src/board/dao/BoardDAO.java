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
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 글저장
	public int insertArticle(BoardBean bean) {
		int su = 0;
		String sql = "insert into board2 values (seq_num.nextval, ?, ?, ?, ?," 
				   + " ?, seq_num.currval, 0, 0, 0, sysdate)";
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
	// 글 리스트
	public List<BoardBean> selectArticleList(int startNum, int endNum) {
		List<BoardBean> list = new ArrayList<BoardBean>();
		/*String sql ="select board_num, board_subject, board_name, board_date, board_readcount " + 
				" from (select rownum rn,tt.*from(select * from board2 order by board_num desc)tt) "+
				" where rn>=? and rn<=?";*/
		String sql = "select * from (select rownum rn, tt.*from(select * from board2 order by board_re_ref desc, board_re_seq asc)tt) " + 
				" where rn>=? and rn <=?";
		try {
			conn= ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardBean bean = new BoardBean();
				bean.setBoard_num(rs.getInt("board_num"));
				bean.setBoard_subject(rs.getString("board_subject"));
				bean.setBoard_name(rs.getString("board_name"));
				bean.setBoard_date(rs.getString("board_date"));
				bean.setBoard_readcount(rs.getInt("board_readcount"));
				bean.setBoard_re_lev(rs.getInt("board_re_lev"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// 총 글수
	public int total() {
		int su=0;
		String sql="select count(*) from board2";
		try {
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				su=rs.getInt(1);		// 첫번째 데이터 얻어오기
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	// 글 내용보기
	public BoardBean view(int board_num) {
		BoardBean bean = new BoardBean();
		String sql = "select*from board2 where board_num = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setBoard_name(rs.getString("board_name"));
				bean.setBoard_subject(rs.getString("board_subject"));
				bean.setBoard_content(rs.getString("board_content"));
				bean.setBoard_file(rs.getString("board_file"));
				bean.setBoard_pass(rs.getString("board_pass"));
				bean.setBoard_re_ref(rs.getInt("board_re_ref"));
				bean.setBoard_re_seq(rs.getInt("board_re_seq"));
				bean.setBoard_re_lev(rs.getInt("board_re_lev"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return bean;
	}
	// 조회수 증가
	public int countUp(int board_num) {
		int su=0;
		String sql = "UPDATE board2 set board_readcount = board_readcount+1 where board_num = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	
		return su;
	}
	// 글 삭제
	public int del(int board_num) {
		int su=0;
		String sql="delete board2 where board_num=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return su;
	}
	// 글 삭제2
	public boolean isArticleBoardWriter(int board_num, String pass) {
		boolean isWriter = false;
		String sql="select * from board2 where board_num=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(pass.equals(rs.getString("board_pass"))) {
					isWriter = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return isWriter;
	}
	// 글 삭제
	public int deleteArticle(int board_num) {
		int deleteCount = 0;
		String sql="delete board2 where board_num=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return deleteCount;
	}
	// 글 수정
	public int update(int board_num, BoardBean bean) {
		int su=0;
		String sql="";
		if(bean.getBoard_file() == null) {
			sql ="UPDATE board2 set board_name = ?,board_pass=?,board_subject=?,board_content=? where board_num = ?";
		} else {
			sql ="UPDATE board2 set board_file=?, board_name = ?,board_pass=?,board_subject=?,board_content=? where board_num = ?";
		}
		try {
			conn = ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			if(bean.getBoard_file() == null) {
			pstmt.setString(1, bean.getBoard_name());
			pstmt.setString(2, bean.getBoard_pass());
			pstmt.setString(3, bean.getBoard_subject());
			pstmt.setString(4, bean.getBoard_content());
			pstmt.setInt(5, board_num);
			} else {
				pstmt.setString(1, bean.getBoard_file());
				pstmt.setString(2, bean.getBoard_name());
				pstmt.setString(3, bean.getBoard_pass());
				pstmt.setString(4, bean.getBoard_subject());
				pstmt.setString(5, bean.getBoard_content());
				pstmt.setInt(6, board_num);
			}
			su= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	// 답글 저장 sql 2번 동작
	public int insertReplyArticle(BoardBean boardBean) {
		int su=0;
//		upReply(boardBean.getBoard_re_ref(), boardBean.getBoard_re_seq());
		String sql1 = "update board2 set board_re_seq = board_re_seq+1 " + 
				" where board_re_ref=? and board_re_seq>?";
		String sql2 = "insert into BOARD2 values(seq_num.nextval,?,?,?,?,' ',?,?,?,0,sysdate)";
		// 원글에 대한 값
		int re_ref = boardBean.getBoard_re_ref();
		int re_lev = boardBean.getBoard_re_lev();
		int re_seq = boardBean.getBoard_re_seq();
		try {
			conn = ds.getConnection();
			// 기존 답글의 등록순서를 재정리
			// => 원글 re_seq보다 큰 답글 re_seq를 1씩 증가
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			pstmt.executeUpdate();
			// 답글 저장
			// 추가된 답글의 re_seq는 원글 re_seq에 1증가한 값을 가진다.
			// 또한, 추가된 답글의 re_lev는 원글 re_lev에 증가한 값을 가진다.
			re_seq= re_seq+1;
			re_lev= re_lev+1;
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, boardBean.getBoard_name());
			pstmt.setString(2, boardBean.getBoard_pass());
			pstmt.setString(3, boardBean.getBoard_subject());
			pstmt.setString(4, boardBean.getBoard_content());
			pstmt.setInt(5, boardBean.getBoard_re_ref());
			pstmt.setInt(6, re_lev);
			pstmt.setInt(7, re_seq);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	// 기존답글의 등록순서 재정리
	public void upReply(int board_re_ref, int board_re_seq) {
		int up = 0;
		String sql ="update board2 set board_re_seq = board_re_seq+1 " + 
				" where board_re_ref=? and board_re_seq>?"; 
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_re_ref);
			pstmt.setInt(2, board_re_seq);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
}












