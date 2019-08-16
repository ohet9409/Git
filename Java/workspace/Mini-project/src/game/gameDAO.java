package game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class gameDAO {
	public gameDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

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

	// 상위 5위 랭킹
	public List<gameDTO> rank() {
		List<gameDTO> list = new ArrayList<gameDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "select e.* from(select substr(name,1,10) player, time, gamedate, rank() over (order by time asc) as rank from game ) e where rownum<=5";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				gameDTO dto = new gameDTO();
				dto.setPlayer(rs.getString("player"));
				dto.setTime(rs.getInt("time"));
				dto.setGamedate(rs.getString("gamedate"));
				dto.setRank(rs.getInt("rank"));
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

	// 자신의 랭킹 확인
	public List<gameDTO> myRank(String player) {
		List<gameDTO> list = new ArrayList<gameDTO>();
		String sql = "select count(*)+1 as rank from game where code < (select time from game where player = ?) order by  asc";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				gameDTO dto = new gameDTO();
				dto.setRank(rs.getInt("rank"));
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

	// 자신의 랭킹과 모든 정보
	public List<gameDTO> my(String player) {
		List<gameDTO> list = new ArrayList<gameDTO>();
		String sql = "select * from game where player = ?";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				gameDTO dto = new gameDTO();
				dto.setPlayer(rs.getString("player"));
				dto.setTime(rs.getInt("time"));
				dto.setGamedate(rs.getString("gamedate"));
				myRank(player);
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
}
