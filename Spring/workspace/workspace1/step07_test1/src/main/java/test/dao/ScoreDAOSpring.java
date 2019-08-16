package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

@Repository
public class ScoreDAOSpring {
	// JDBC 관련 변수
	@Autowired
	private JdbcTemplate jdbcTemplate;
	// SQL문
	String score_insert = "insert into score values (?, ?, ?, ?, ?, ?, ?, sysdate)";
	String score_update = "update score set kor=?, eng=?, mat=?, tot=?, avg=? " 
						+ " where studNo=?";
	String score_delete = "delete score where studNo=?";
	String score_list = "select * from score order by studNo asc";
	/* CRUD 기능의 메소드 */
	// 성적 저장
	public int insertScore(ScoreVO vo) {
		// 방법1
//		return jdbcTemplate.update(score_insert, vo.getStudNo(), vo.getName(),
//				vo.getKor(), vo.getEng(), vo.getMat(), vo.getTot(), vo.getAvg());
		// 방법2
		Object[] args = {vo.getStudNo(), vo.getName(), vo.getKor(), 
				vo.getEng(), vo.getMat(), vo.getTot(), vo.getAvg()};
		return jdbcTemplate.update(score_insert, args);
	}
	// 성적 수정
	public int updateScore(ScoreVO vo) {
		Object[] args = {vo.getKor(), vo.getEng(), vo.getMat(), vo.getTot(),
				vo.getAvg(), vo.getStudNo()};
		return jdbcTemplate.update(score_update, args);
	}
	// 성적 삭제
	public int deleteScore(ScoreVO vo) {		
		return jdbcTemplate.update(score_delete, vo.getStudNo());
	}
	// 성적 목록보기
	public List<ScoreVO> getScoreList() {		
		return jdbcTemplate.query(score_list, new ScoreRowMapper());
	}	
}









