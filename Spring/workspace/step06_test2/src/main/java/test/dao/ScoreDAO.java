package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

// @Repository : bean객체 선언
@Repository
public class ScoreDAO {
	// JDBC 관련 변수
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	// SQL 명령어들
	String score_insert = "INSERT INTO score VALUES (?,?,?,?,?,?,?,SYSDATE)";
	String score_update = "UPDATE score SET name = ?, kor=?, eng=?,mat=?,tot=?,avg=? where studNo = ?";
	String score_delete = "DELETE score where studNo = ?";
	String score_get = "SELECT * FROM score WHERE studNo = ?";
	String score_list = "SELECT * FROM score ORDER BY studNo asc";
	
	/* CRUD 기능의 메소드 구현 */
	// 점수 등록
	public int insertScore(ScoreVO vo) {
		int su = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(score_insert);
			pstmt.setString(1, vo.getStudNo());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getMat());
			pstmt.setInt(6, vo.getTot());
			pstmt.setDouble(7, vo.getAvg());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return su;
	}
	
	// 점수 수정
	public int updateScore(ScoreVO vo) {
		int su = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(score_update);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getTot());
			pstmt.setDouble(6, vo.getAvg());
			pstmt.setString(7, vo.getStudNo());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return su;
	}
	
	// 점수 삭제
	public int deleteScore(ScoreVO vo) {
		int su = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(score_delete);
			pstmt.setString(1, vo.getStudNo());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return su;
	}
	
	// 점수 출력
	public List<ScoreVO> listScore() {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(score_list);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ScoreVO scoreVO = new ScoreVO();
				scoreVO.setStudNo(rs.getString("studNo"));
				scoreVO.setName(rs.getString("name"));
				scoreVO.setKor(rs.getInt("kor"));
				scoreVO.setEng(rs.getInt("eng"));
				scoreVO.setMat(rs.getInt("mat"));
				scoreVO.setTot(rs.getInt("tot"));
				scoreVO.setAvg(rs.getDouble("avg"));
				scoreVO.setLogtime(rs.getString("logtime"));
				list.add(scoreVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}
	
	// 메인 메뉴
	public int menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 입력");
		System.out.println("2. 출력");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 종료");
		System.out.println("--------------");
		System.out.print("번호 : ");
		int no = sc.nextInt();
		return no;
	}
}
