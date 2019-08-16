package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

// @Repository : bean객체 선언
@Repository
public class ScoreDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL 명령어들
	String score_insert = "INSERT INTO score VALUES (?,?,?,?,?,?,?,SYSDATE)";
	String score_update = "UPDATE score SET name = ?, kor=?, eng=?,mat=?,tot=?,avg=? where studNo = ?";
	String score_delete = "DELETE score where studNo = ?";
	String score_get = "SELECT * FROM score WHERE studNo = ?";
	String score_list = "SELECT * FROM score ORDER BY studNo asc";
	
	/* CRUD 기능의 메소드 구현 */
	// 점수 등록
	public int insertScore(ScoreVO vo) {
		// 방법 1
		//return jdbcTemplate.update(score_insert, vo.getStudNo(), vo.getName(), vo.getKor(), vo.getEng(), vo.getMat(), vo.getTot(), vo.getAvg());
		// 방법 2
		Object[] args = {vo.getStudNo(), vo.getName(), vo.getKor(), vo.getEng(), vo.getMat(), vo.getTot(), vo.getAvg()};
		return jdbcTemplate.update(score_insert, args);
	}
	
	// 점수 수정
	public int updateScore(ScoreVO vo) {
		return jdbcTemplate.update(score_update, vo.getName(), vo.getKor(), vo.getEng(), vo.getMat(), vo.getTot(), vo.getAvg(), vo.getStudNo());
	}
	
	// 점수 삭제
	public int deleteScore(ScoreVO vo) {
		return jdbcTemplate.update(score_delete, vo.getStudNo());
	}
	
	// 점수 출력
	public List<ScoreVO> listScore() {
		return jdbcTemplate.query(score_list, new ScoreRowMapper());
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
