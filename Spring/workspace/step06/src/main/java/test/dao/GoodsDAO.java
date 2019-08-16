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
	String goods_insert = "INSERT INTO goods VALUES (?,?,?,?)";
	String goods_update = "UPDATE goods SET name = ?, price=?, maker=? where code = ?";
	String goods_delete = "DELETE goods where code = ?";
	String goods_get = "SELECT * FROM goods WHERE code =?";
	String goods_list = "SELECT * FROM goods ORDER BY code asc";
	/* CRUD 기능의 메소드 구현 */
	// 책 등록
	public int insertGoods(GoodsVO vo) {
		int su =0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_insert);
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getMaker());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return su;
	}
	// 책 수정
	public int updateGoods(GoodsVO vo) {
		int su=0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_update);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getMaker());
			pstmt.setString(4, vo.getCode());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return su;
	}
	// 책 삭제
	public int deleteGoods(GoodsVO vo) {
		int su =0;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_delete);
			pstmt.setString(1, vo.getCode());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	
		return su;
	}
	// 책 상세조회
	public GoodsVO getGoods(GoodsVO vo) {
		GoodsVO vo1 = null;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_get);
			pstmt.setString(1, vo.getCode());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo1 = new GoodsVO();
				vo1.setCode(rs.getString("code"));
				vo1.setName(rs.getString("name"));
				vo1.setPrice(rs.getInt("price"));
				vo1.setMaker(rs.getString("maker"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return vo1;
	}
	// 책 목록조회
	public List<GoodsVO> getGoodsList() {
		List<GoodsVO> list = new ArrayList<GoodsVO>();
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(goods_list);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GoodsVO vo = new GoodsVO();
				vo.setCode(rs.getString("code"));
				vo.setMaker(rs.getString("maker"));
				vo.setName(rs.getString("name"));
				vo.setPrice(rs.getInt("price"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}
}
