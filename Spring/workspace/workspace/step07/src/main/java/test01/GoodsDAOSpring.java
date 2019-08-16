package test01;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsDAOSpring {
		@Autowired
		private JdbcTemplate jdbcTemplate;	// rs, pstmt, conn을 대체함.
		
		// SQL 명령어들
		String goods_insert = "insert into goods values (?, ?, ?, ?)";
		String goods_update = "update goods set name=?, price=?, maker=? where code=?";
		String goods_delete = "delete goods where code = ?";
		String goods_get = "select * from goods where code = ?";
		String goods_list = "select * from goods order by code asc";
		/* CRUD 기능의 메소드 구현 */
		// 책등록
		public int insertGoods(GoodsVO vo) {
			int result = 0;
			result = jdbcTemplate.update(goods_insert, 
						vo.getCode(), vo.getName(), vo.getPrice(), vo.getMaker());
			return result;
		}
		// 책수정
		public int updateGoods(GoodsVO vo) {			
			return jdbcTemplate.update(goods_update, 
						vo.getName(), vo.getPrice(), vo.getMaker(), vo.getCode());
		}
		// 책삭제
		public int deleteGoods(GoodsVO vo) {			
			return jdbcTemplate.update(goods_delete, vo.getCode());
		}
		// 책 상세조회
		public GoodsVO getGoods(GoodsVO vo) {
			Object[] args = {vo.getCode()};
			return jdbcTemplate.queryForObject(goods_get, args, new GoodsRowMapper());
		}
		// 책 목록조회
		public List<GoodsVO> getGoodsList() {			
			return jdbcTemplate.query(goods_list, new GoodsRowMapper());
		}
}





