package com.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import org.w3c.dom.ls.LSInput;

import oracle.sql.ARRAY;

// JDBC 기능 구현
public class Dao {
	// 1. Driver 등록확인
	public Dao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 2. Connection
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "jspexam";
		String password = "m1234";
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	// 3. SQL 작업처리
	// 입력 : insert
	public int insertArticle(Dto dto) {
		String sql = "insert into school values (?,?,?)";
		int su = 0; // 처리된 데이터 갯수 저장
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getValue());
			pstmt.setInt(3, dto.getCode());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return su;
	}

	// 이름검색 : 일치된 1명만 돌려쥼
	public Dto selectOne(String name) {
		String sql = "select * from school where name = ?";
		Dto dto = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null; // 검색 결과 저장
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery(); // 오라클 서버로부터 sql문을 요청하고 결과를 받아옴
			if (rs.next()) {
				dto = new Dto();
				dto.setName(rs.getString("name"));
				dto.setValue(rs.getString("value"));
				dto.setCode(rs.getInt("code"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto; // name, value, code가 한번에 리턴됨
	}

	// 이름검색 : 이름중 일치되는 데이터가 있는 사람들 검색
	public List<Dto> selectArticle(String name) {
		String sql = "select * from school where name like ?";
		List<Dto> list = new ArrayList<Dto>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Dto dto = new Dto();
				dto.setName(rs.getString("name"));
				dto.setValue(rs.getString("value"));
				dto.setCode(rs.getInt("code"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return list; // 여러명이기 때문에 list에 담아서 리턴 한다.
	}

	// 전체검색
	public List<Dto> selectList() {
		String sql = "select * from school";
		List<Dto> list = new ArrayList<Dto>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Dto dto = new Dto();
				dto.setName(rs.getString("name"));
				dto.setValue(rs.getString("value"));
				dto.setCode(rs.getInt("code"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	// 삭제
	public int deleteArticle(String name) {
		String sql = "delete from school where name = ?";
		int su = 0; // 처리된 데이터 갯수 저장
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			su = pstmt.executeUpdate(); // 오라클서버에 요청, 응답 처리
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated ca tch block
				e.printStackTrace();
			}
		}
		return su;
	}

	public int updateArticle(Dto dto) {
		String sql = "update school set value = ?, code = ? where name = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getValue());
			pstmt.setInt(2, dto.getCode());
			pstmt.setString(3, dto.getName());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return su;
	}

	public List<Dto> ShowRank() {
		String sql = "select name, value, code,DENSE_RANK() over (order by code asc) as rank from school";
		List<Dto> list = new ArrayList<Dto>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Dto gdto = new Dto();
				gdto.setName(rs.getString("name"));
				gdto.setValue(rs.getString("value"));
				gdto.setCode(rs.getInt("code"));
				gdto.setRank(rs.getInt("rank"));
				list.add(gdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return list;
	}

	public List<Dto> ShowRank(String name) {
		String sql2 = "select count(*)+1 as rank from school where code > (select code from school where name = ?) order by code asc";
		List<Dto> list = new ArrayList<Dto>();
		Connection conn2 = getConnection();
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		try {

			pstmt2 = conn2.prepareStatement(sql2);

			pstmt2.setString(1, "%" + name + "%");

			rs2 = pstmt2.executeQuery();

			while (rs2.next()) {
				Dto gdto = new Dto();
				gdto.setRank(rs2.getInt("rank"));
				list.add(gdto);
			}
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt2 != null)
					pstmt2.close();

				if (conn2 != null)
					conn2.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return list;
	}

	public List<Dto> ShowName(String name) {
		String sql = "select * from school where name = ?";
		List<Dto> list = new ArrayList<Dto>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql2 = "select count(*)+1 as rank from school where code < (select code from school where name = ?) order by code asc";
		Connection conn2 = getConnection();
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn2.prepareStatement(sql2);
			pstmt.setString(1, name );
			pstmt2.setString(1, name);
			rs = pstmt.executeQuery();
			rs2=pstmt2.executeQuery();
			while (rs.next()) {
				Dto gdto = new Dto();
				gdto.setName(rs.getString("name"));
				gdto.setValue(rs.getString("value"));
				gdto.setCode(rs.getInt("code"));
				while(rs2.next())
				gdto.setRank(rs2.getInt("rank"));
				list.add(gdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (pstmt2 != null)
					pstmt2.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void ShowName1(String name) {
		String sql = "select * from school where name = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  name );
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name2 =rs.getString("name");
				String value2=rs.getString("value");
				int code2=rs.getInt("code");
				System.out.println(name2 +" "+ value2 +" "+ code2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public List<Dto> ShowNamehap(String name) {
		String sql = "select * from school where name = ?";
		List<Dto> list = new ArrayList<Dto>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name );
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Dto gdto = new Dto();
				gdto.setName(rs.getString("name"));
				gdto.setValue(rs.getString("value"));
				gdto.setCode(rs.getInt("code"));
				ShowRank(name);
				list.add(gdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
