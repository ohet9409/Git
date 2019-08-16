package test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import test.bean.ScoreVO;

// sql문 중에서 select 명령어를 사용할 경우, 리턴값으로 자바빈즈나 List를 돌려줄 때
// 사용할 자바빈즈 설정
public class ScoreRowMapper implements RowMapper<ScoreVO>{

	@Override
	public ScoreVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ScoreVO vo = new ScoreVO();
		vo.setStudNo(rs.getString("studNo"));
		vo.setName(rs.getString("name"));
		vo.setKor(rs.getInt("kor"));
		vo.setEng(rs.getInt("eng"));
		vo.setMat(rs.getInt("mat"));
		vo.setTot(rs.getInt("tot"));
		vo.setAvg(rs.getDouble("avg"));
		vo.setLogtime(rs.getString("logtime"));
		return vo;
	}

}









