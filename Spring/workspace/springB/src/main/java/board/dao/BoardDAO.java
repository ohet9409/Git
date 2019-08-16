package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;
@Repository
public class BoardDAO {	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	// 데이터 저장
	public int boardWrite(BoardDTO boardDTO) {
		
		return sessionTemplate.insert("mybatis.board.boardWrite", boardDTO);
	}
	
	public List<BoardDTO> boardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sessionTemplate.selectList("mybatis.board.boardList", map);
	}
	// 1줄 검색
	public BoardDTO boardView(int seq) {
		
		return sessionTemplate.selectOne("mybatis.board.boardView", seq);
	}
	// 총 글수 구하기
	public int getTotalA() {
		
		return sessionTemplate.selectOne("mybatis.board.getTotalA");
	}
	// 조회수 증가
	public int updateHit(int seq) {
		
		return sessionTemplate.update("mybatis.board.updateHit",seq);
	}
	// 글삭제
	public int boardDelete(int seq) {
		
		return sessionTemplate.delete("mybatis.board.boardDelete",seq);
	}
	
	public int boardModify(BoardDTO boardDTO) {
		
		return sessionTemplate.update("mybatis.board.boardModify",boardDTO);	
	}
}





















