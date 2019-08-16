package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import book.Bean.BookDTO;

public class BookDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	// Datasource 얻어오기
	public BookDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 데이터 저장
	public int write(BookDTO bookDTO) {
		int su=0;
		String sql = "insert into book VALUES(?,?,?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookDTO.getCode());
			pstmt.setString(2, bookDTO.getBook());
			pstmt.setString(3, bookDTO.getWriter());
			pstmt.setString(4, bookDTO.getPublisher());
			pstmt.setInt(5, bookDTO.getPrice());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	// 데이터 출력
	public List<BookDTO> list(int startNum, int endNum) {
		List<BookDTO> list = new ArrayList<BookDTO>();
		String sql = "select code, book, writer, publisher, price " + 
				" from (select rownum rn,tt.*from(select * from book order by code asc)tt) where rn>=? and rn<=?";
		try {
			conn = ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getInt("code"));
				dto.setBook(rs.getString("book"));
				dto.setWriter(rs.getString("writer"));
				dto.setPublisher(rs.getString("publisher"));
				dto.setPrice(rs.getInt("price"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	// 데이터 총 개수
	public int total() {
		int su=0;
		String sql = "select count(*) as count from book";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				su = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			close();
		}
		return su;
	}
	
}
