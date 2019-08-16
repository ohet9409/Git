package imageboard.dao;

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

import imageboard.bean.ImageboardDTO;

public class ImageboardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	// Datasource 얻어오기
	public ImageboardDAO() {
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

	// 이미지 등록
	public int imageWrite(ImageboardDTO dto) {
		int su = 0;
		String sql = "INSERT into imageboard VALUES(seq_imageboard.nextval, " + " ?,?,?,?,?,?,sysdate)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getImageId());
			pstmt.setString(2, dto.getImageName());
			pstmt.setInt(3, dto.getImagePrice());
			pstmt.setInt(4, dto.getImageQty());
			pstmt.setString(5, dto.getImageContent());
			pstmt.setString(6, dto.getImage1());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}

	// 이미지 리스트
	public List<ImageboardDTO> imageList(int startNum, int endNum) {
		List<ImageboardDTO> list = new ArrayList<ImageboardDTO>();
		String sql = "select seq, imageId, imageName, imagePrice, imageQty, imageContent, image1, to_char(logtime,'YY/MM/DD')AS logtime "
				+ " from (select rownum rn,tt.*from(select * from imageboard order by seq desc)tt) where rn>=? and rn<=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ImageboardDTO dto = new ImageboardDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setImageId(rs.getString("imageId"));
				dto.setImageContent(rs.getString("imageContent"));
				dto.setLogtime(rs.getString("logtime"));
				dto.setImage1(rs.getString("image1"));
				dto.setImageName(rs.getString("imageName"));
				dto.setImagePrice(rs.getInt("imagePrice"));
				dto.setImageQty(rs.getInt("imageQty"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	// 이미지 총 글수
	public int totalA() {
		int count = 0;
		String sql = "select count(*)as count from imageboard";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return count;
	}

	// 글 자세히 보기
	public ImageboardDTO imageboardView(int seq) {
		ImageboardDTO imageboardDTO = null;
		String sql = "select * from imageboard where seq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				imageboardDTO = new ImageboardDTO();
				imageboardDTO.setSeq(rs.getInt("seq"));
				imageboardDTO.setImageId(rs.getString("imageId"));
				imageboardDTO.setImageName(rs.getString("imageName"));
				imageboardDTO.setImagePrice(rs.getInt("imagePrice"));
				imageboardDTO.setImageQty(rs.getInt("imageQty"));
				imageboardDTO.setImageContent(rs.getString("imageContent"));
				imageboardDTO.setImage1(rs.getString("image1"));
				imageboardDTO.setLogtime(rs.getString("logtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return imageboardDTO;
	}

	// 글 삭제
	public int imageboardDelete(int seq) {
		int su = 0;
		String sql = "delete imageboard where seq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			su = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	// 글 수정

	public int imageboardUpdate(int seq, ImageboardDTO imageboardDTO) { 
		 int su=0; 
		 String sql =null;
		 if(imageboardDTO.getImage1() == null) {
			 sql ="UPDATE imageboard set IMAGEID=?, imageName=?, IMAGEPRICE=?, " + 
			 		" IMAGEQTY=?, IMAGECONTENT=? where seq=?";
		 } else {
			 sql ="UPDATE imageboard set IMAGEID=?, imageName=?, IMAGEPRICE=?, " + 
			 		" IMAGEQTY=?, IMAGECONTENT=?, IMAGE1=? where seq=?";
		 }
		 try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(imageboardDTO.getImage1() == null) {
			pstmt.setString(1, imageboardDTO.getImageId());
			pstmt.setString(2, imageboardDTO.getImageName());
			pstmt.setInt(3, imageboardDTO.getImagePrice());
			pstmt.setInt(4, imageboardDTO.getImageQty());
			pstmt.setString(5, imageboardDTO.getImageContent());
			pstmt.setInt(6, seq);
			} else {
				pstmt.setString(1, imageboardDTO.getImageId());
				pstmt.setString(2, imageboardDTO.getImageName());
				pstmt.setInt(3, imageboardDTO.getImagePrice());
				pstmt.setInt(4, imageboardDTO.getImageQty());
				pstmt.setString(5, imageboardDTO.getImageContent());
				pstmt.setString(6, imageboardDTO.getImage1());
				pstmt.setInt(7, seq);
				}
			su=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		 
		 return su; 
	}

}
