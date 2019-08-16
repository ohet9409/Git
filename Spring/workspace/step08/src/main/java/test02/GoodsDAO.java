package test02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class GoodsDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	// SQL 명령어들
	// mybatis에서 설정
	
	/* CRUD 기능의 메소드 구현 */
	// 책 등록
	public int insertGoods(GoodsVO vo) {
		// insert("namespace.태그아이디",parameter값)
		return sqlSession.insert("mybatis.goodsMapper.insertGoods", vo);
		
	}
	// 책 수정
	public int updateGoods(GoodsVO vo) {
		return sqlSession.update("mybatis.goodsMapper.updateGoods", vo);
	}
	// 책 삭제
	public int deleteGoods(GoodsVO vo) {
		return sqlSession.delete("mybatis.goodsMapper.deleteGoods", vo);
	}
	// 책 상세조회
	public GoodsVO getGoods(GoodsVO vo) {
		Object[] args = {vo.getCode()};
		return sqlSession.selectOne("mybatis.goodsMapper.getGoods", vo);
	}
	// 책 목록조회
	public List<GoodsVO> getGoodsList() {
		return sqlSession.selectList("mybatis.goodsMapper.getGoodsList");
	}
}
