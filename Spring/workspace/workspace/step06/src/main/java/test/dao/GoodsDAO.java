package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import test.bean.GoodsVO;

@Repository
public class GoodsDAO {
	// JDBC 관련 변수
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
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
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_insert);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getMaker());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	// 책수정
	public int updateGoods(GoodsVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_update);			
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getMaker());
			pstmt.setString(4, vo.getCode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	// 책삭제
	public int deleteGoods(GoodsVO vo) {
		int result = 0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_delete);			
			pstmt.setString(1, vo.getCode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return result;
	}
	// 책 상세조회
	public GoodsVO getGoods(GoodsVO vo) {
		GoodsVO goodsVO = null;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_get);
			pstmt.setString(1, vo.getCode());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				goodsVO = new GoodsVO();
				goodsVO.setCode(rs.getString("code"));
				goodsVO.setName(rs.getString("name"));
				goodsVO.setPrice(rs.getInt("price"));
				goodsVO.setMaker(rs.getString("maker"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return goodsVO;
	}
	// 책 목록조회
	public List<GoodsVO> getGoodsList() {
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_list);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsVO goodsVO = new GoodsVO();
				goodsVO.setCode(rs.getString("code"));
				goodsVO.setName(rs.getString("name"));
				goodsVO.setPrice(rs.getInt("price"));
				goodsVO.setMaker(rs.getString("maker"));
				
				list.add(goodsVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}
}











