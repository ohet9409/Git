package board.dao;

import java.sql.Connection;
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
	private SqlSessionTemplate sqlSession;

	// �� ��� �����ֱ�
	public List<BoardDTO> boardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return sqlSession.selectList("mybatis.boardMapper.boardList", map);
	}
	
	// �� �ۼ�
	public int count() {
		return sqlSession.selectOne("mybatis.boardMapper.count");
	}
	
	// �� ���� ����
	public BoardDTO boardView(int seq) {
		
		return sqlSession.selectOne("mybatis.boardMapper.boardView",seq);
	}
	// ��ȸ�� ����
	public int countHit(int seq) {
		
		return sqlSession.update("mybatis.boardMapper.countHit",seq);
	}
	// �� ����
	public int boardDelete(int seq) {
		return sqlSession.delete("mybatis.boardMapper.boardDelete",seq);
	}
	// �� �߰�
	public int boardWrite(BoardDTO dto) {
		return sqlSession.insert("mybatis.boardMapper.boardWrite",dto);
	}
	
}
