package test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class GoodsDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;	// rs, pstmt, conn을 대체함.
	
	// SQL 명령어들
	String goods_insert = "INSERT INTO goods VALUES (?,?,?,?)";
	String goods_update = "UPDATE goods SET name = ?, price=?, maker=? where code = ?";
	String goods_delete = "DELETE goods where code = ?";
	String goods_get = "SELECT * FROM goods WHERE code =?";
	String goods_list = "SELECT * FROM goods ORDER BY code asc";
	/* CRUD 기능의 메소드 구현 */
	// 책 등록
	public int insertGoods(GoodsVO vo) {
		int su =0;
		su = jdbcTemplate.update(goods_insert, vo.getCode(), vo.getName(), vo.getPrice(), vo.getMaker());
		return su;
	}
	// 책 수정
	public int updateGoods(GoodsVO vo) {
		return jdbcTemplate.update(goods_update, vo.getName(), vo.getPrice(), vo.getMaker(), vo.getCode());
	}
	// 책 삭제
	public int deleteGoods(GoodsVO vo) {
		return jdbcTemplate.update(goods_delete, vo.getCode());
	}
	// 책 상세조회
	public GoodsVO getGoods(GoodsVO vo) {
		Object[] args = {vo.getCode()};
		//queryForObject: 한가지만 리턴
									//     sql        ?      vo정의 클래스
		return jdbcTemplate.queryForObject(goods_get,args , new GoodsRowMapper());
	}
	// 책 목록조회
	public List<GoodsVO> getGoodsList() {
		// query: list형태로 return
		return jdbcTemplate.query(goods_list, new GoodsRowMapper());
	}
}
