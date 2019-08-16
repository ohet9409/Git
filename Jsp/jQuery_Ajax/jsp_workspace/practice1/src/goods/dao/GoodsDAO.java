package goods.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import goods.bean.GoodsDTO;

public class GoodsDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "jspexam";
	String password = "m1234";

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public GoodsDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// 생성
	public int goodsWrite(GoodsDTO goodsDTO) {
		int result = 0;
		String sql = "insert into goods values (?, ?, ?,?)";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goodsDTO.getCode());
			pstmt.setString(2, goodsDTO.getName());
			pstmt.setInt(3, goodsDTO.getPrice());
			pstmt.setString(4, goodsDTO.getMaker());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	// 삭제
	public int goodsDelete(GoodsDTO goodsDTO) {
		int result = 0;
		String sql = "delete goods where code = ?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goodsDTO.getCode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	// 수정
	public int goodsUpdate(GoodsDTO goodsDTO) {
		int result = 0;

		String sql = "update goods set name=?, price=?, maker=? where code = ?";

		/*
		 * String sql = "update goods set name='스프링무따기', price=30000, maker='마춤출판사' " +
		 * "where code = 'p0001'";
		 */
		conn = getConnection();
		try {
			System.out.println("goodsDTO.getName() : " + goodsDTO.getName());
			System.out.println("goodsDTO.getPrice() : " + goodsDTO.getPrice());
			System.out.println("goodsDTO.getMaker() : " + goodsDTO.getMaker());
			System.out.println("goodsDTO.getCode() : " + goodsDTO.getCode());
			pstmt = conn.prepareStatement(sql);
			System.out.println("ps : " + pstmt.getParameterMetaData());
			pstmt.setString(1, goodsDTO.getName());
			pstmt.setInt(2, goodsDTO.getPrice());
			pstmt.setString(3, goodsDTO.getMaker());
			pstmt.setString(4, goodsDTO.getCode());
			System.out.println("result1 : " + result);
			result = pstmt.executeUpdate();
			System.out.println("result2 : " + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	// 전체 출력
	public List<GoodsDTO> goodsList() {
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		String sql = "select * from goods order by code asc";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GoodsDTO goodsDTO = new GoodsDTO();
				goodsDTO.setCode(rs.getString("code"));
				goodsDTO.setName(rs.getString("name"));
				goodsDTO.setPrice(rs.getInt("price"));
				goodsDTO.setMaker(rs.getString("maker"));
				list.add(goodsDTO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 상세 보기
	public GoodsDTO goodsSelect(String code) {
		GoodsDTO goodsDTO = null;
		String sql = "select * from goods where code = ?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				goodsDTO = new GoodsDTO();
				goodsDTO.setCode(rs.getString("code"));
				goodsDTO.setName(rs.getString("name"));
				goodsDTO.setPrice(rs.getInt("price"));
				goodsDTO.setMaker(rs.getString("maker"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return goodsDTO;
	}
}
