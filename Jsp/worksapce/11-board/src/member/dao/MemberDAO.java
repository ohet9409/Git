package member.dao;
/* JDBC 작업단계 
 * 1. Driver Loading
 * 2. Connection
 * 3. SQL 작업처리
 * 4. 반환값 처리
 * 5. 접속 종료
 * */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.bean.MemberDTO;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "jspexam";
	String password = "m1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	// 1. Driver Loading
	public MemberDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 2. Connection
	public Connection getConnection() {

		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	// 5. 접속 종료
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * 3. SQL 작업처리 4. 반환값 처리
	 */
	// 데이터 저장(회원가입)
	public int write(MemberDTO memberDTO) {
		int su =0;
		String sql ="INSERT into MEMBER VALUES(?,?,?,?,?,?,?,?,?,?,sysdate)";
		conn = getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getTel1());
			pstmt.setString(8, memberDTO.getTel2());
			pstmt.setString(9, memberDTO.getTel3());
			pstmt.setString(10, memberDTO.getAddr());
			su = pstmt.executeUpdate();	// 요청, 응답
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	// id 일치 데이터 검색 (로그인)
	public String login(String id, String pwd) {
		String name= null;
		String sql ="SELECT * FROM MEMBER where id=? and pwd=?";
		conn = getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery(); // 서버에 sql 처리요청, 처리결과를 ResultSet에 저장
			if(rs.next()) {		// ResultSet에 저장된 데이터 꺼내기, 성공했으면 true, 실패하면 false
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return name;
	}
	// ID 데이터 검색 (id 중복처리)
	public boolean isExistId(String id) {
		boolean exist = false;
		String sql = "SELECT * from MEMBER where id =?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();	//요청, 응답
			if (rs.next()) {	// 일치하는 ID가 존재할 때
				exist=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return exist;
	}
	// 데이터 수정
	public int modify(MemberDTO memberDTO) {
		int su =0;
		conn = getConnection();
		String sql = "update member set name=?, pwd=?, gender=?, email1=?, email2=?,tel1=?, tel2=?, tel3=?, addr=? where id =?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail1());
			pstmt.setString(5, memberDTO.getEmail2());
			pstmt.setString(6, memberDTO.getTel1());
			pstmt.setString(7, memberDTO.getTel2());
			pstmt.setString(8, memberDTO.getTel3());
			pstmt.setString(9, memberDTO.getAddr());
			pstmt.setString(10, memberDTO.getId());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	// 일치하는 ID의 전체 데이터 불러오기
	public MemberDTO selectOne(String id) {
		MemberDTO memberDTO = null;
		String sql = "select * from member where id=?";
		conn=getConnection();
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setAddr(rs.getString("addr"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return memberDTO;
	}
	
	// 데이터 삭제
	public int delete(String id) {
		int su=0;
		conn=getConnection();
		String sql = "delete member where id = ?";
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, id);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	// 회원 전체 목록을 테이블로 출력
	public List<MemberDTO> selectList() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO dto = null;
		conn = getConnection();
		String sql = "select * from member order by name";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				dto= new MemberDTO();
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setGender(rs.getString("gender"));
				dto.setEmail1(rs.getString("email1"));
				dto.setEmail2(rs.getString("email2"));
				dto.setTel1(rs.getString("tel1"));
				dto.setTel2(rs.getString("tel2"));
				dto.setTel3(rs.getString("tel3"));
				dto.setLogtime(rs.getString("logtime"));
				list.add(dto);
			}
		} catch (SQLException e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}
	
	// 총 회원수 구하기
			public int getTotalB() {
				int totalB = 0;
				String sql ="SELECT count(*) as count from member";
				conn = getConnection();
				try {
					
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						totalB = rs.getInt("count");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close();
				}
				return totalB;
			}
			
			// 회원 전체 목록 보여주기
			public List<MemberDTO> memberList(int startNum, int endNum) {
				MemberDTO memberDTO =null;
				conn=getConnection();
				List<MemberDTO> list = new ArrayList<MemberDTO>();
				String sql= "select name,id, pwd, gender, email1, email2, tel1, tel2, tel3, addr, to_char(logtime, 'YYYY.MM.DD')as logtime"
						+" from (select rownum rn,tt.*from(select * from member order by name desc)tt) where rn>=? and rn<=?";
				try {
					pstmt=conn.prepareStatement(sql);
					pstmt.setInt(1, startNum);
					pstmt.setInt(2, endNum);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						memberDTO = new MemberDTO();
						memberDTO.setName(rs.getString("name"));
						memberDTO.setId(rs.getString("id"));
						memberDTO.setPwd(rs.getString("pwd"));
						memberDTO.setGender(rs.getString("gender"));
						memberDTO.setEmail1(rs.getString("email1"));
						memberDTO.setEmail2(rs.getString("email2"));
						memberDTO.setTel1(rs.getString("tel1"));
						memberDTO.setTel1(rs.getString("tel1"));
						memberDTO.setTel1(rs.getString("tel1"));
						memberDTO.setAddr(rs.getString("addr"));
						memberDTO.setLogtime(rs.getString("logtime"));
						list.add(memberDTO);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					list=null;
				} finally {
					close();
				}
				return list;
			}
}
