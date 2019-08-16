package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;
import member.bean.MemberDTO;

public class BoardDAO {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	// rs: select 문  su: update, delete
	// 커넥션풀 담당 클래스
	DataSource ds;
	
	public BoardDAO() {
		// DataSource 초기화
		try {
			// javax.naming.Context
			Context context = new InitialContext();
			// Tomcat인 경우, <Resource>를 읽어올 때, "java:comp/env"를 붙여야 한다.
			// context.xml의 Context => Resource => name 까지를 나타낸다.
			// lookup메소드는 "java:comp/env/jdbc/oracle" 이름을 가지고 DataSource 객체를 얻어온다.
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
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
		String sql = "insert into board values (seq_board.nextval, ?, ?,?,?,0,sysdate)";
		try {
			conn=ds.getConnection();
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
	
	// 전체 목록 보여주기
	public List<BoardDTO> boardList(int startNum, int endNum) {
		BoardDTO boardDTO =null;
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql="select seq, id, name, subject, content, hit, to_char(logtime, 'YYYY.MM.DD')as logtime" 
					+ " from (select rownum rn,tt.*from(select * from board order by seq desc)tt) where rn>=? and rn<=?";
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getString("logtime"));
				list.add(boardDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list=null;
		} finally {
			close();
		}
		return list;
	}
	// 글 내용 보여주기
	public BoardDTO boardView(int seq) {
		BoardDTO dto = null;
		String sql = "Select * from board where seq = ?";
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs= pstmt.executeQuery();
			if(rs.next()) {
				dto = new BoardDTO();
				dto.setId(rs.getString("id"));
			    dto.setSubject(rs.getString("subject"));
			    dto.setContent(rs.getString("content"));
			    dto.setName(rs.getString("name"));
			    dto.setSeq(rs.getInt("seq"));
			    dto.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return dto;
	}
	
	// 총 글수 구하기
	public int getTotalA() {
		int totalA = 0;
		String sql ="SELECT count(*) as count from BOARD";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalA = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return totalA;
	}
	// 조회수 증가
	public int updateHit(int seq) {
		int su = 0;
		String sql = "UPDATE BOARD set HIT = hit+1 where seq = ?";
		try {
			conn= ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			su=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return su;
	}
	// 글삭제
	public int boardDelete(int seq) {
		int su = 0;
		String sql="delete board where seq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			su=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	// 글 수정
	public int boardModify(BoardDTO boardDTO, int seq) {
		int su=0;
		String sql = "UPDATE BOARD set subject=?, content=?  where seq = ?";
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getSubject());
			pstmt.setString(2, boardDTO.getContent());
			pstmt.setInt(3, seq);
			su=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return su;
	}
	/*
	 * // 글 전체 불러오기 public List<BoardDTO> name(int seq) { BoardDTO dto;
	 * List<BoardDTO> list; String
	 * sql="select subject, content from BOARD where SEQ=?"; try { dto= new
	 * BoardDTO(); list = new ArrayList<BoardDTO>(); conn=ds.getConnection();
	 * pstmt=conn.prepareStatement(sql); pstmt.setInt(1, seq);
	 * rs=pstmt.executeQuery(); dto.setSubject(rs.getString("subject"));
	 * dto.setContent(rs.getString("content")); list.add(dto); } catch (SQLException
	 * e) { e.printStackTrace(); list=null; } return list; }
	 */
	
}
