package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

// @Repository : bean객체 선언
@Repository
public class ScoreDAOSpring {
	// JDBC 관련 변수
	private SqlSession sqlSession;
	// 생성자 생성
	public ScoreDAOSpring() {
		// SqlSession 불러옴
		sqlSession = SqlMapClientFactory.getSqlMapClientInstance();
	}
	
	/* CRUD 기능의 메소드 구현 */
	// 점수 등록
	public int insertScore(ScoreVO vo) {
		return sqlSession.insert("mybatis.scoreMapper.insertScore", vo);
	}
	
	// 점수 수정
	public int updateScore(ScoreVO vo) {
		return sqlSession.update("mybatis.scoreMapper.updateScore", vo);
	}
	
	// 점수 삭제
	public int deleteScore(ScoreVO vo) {
		return sqlSession.delete("mybatis.scoreMapper.deleteScore", vo);
	}
	
	// 점수 출력
	public List<ScoreVO> listScore() {
		return sqlSession.selectList("mybatis.scoreMapper.listScore");
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
