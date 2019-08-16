package guest.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import guest.bean.GuestDTO;
@Repository
public class GuestDAO {
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	// 글 쓰기
	public int input(GuestDTO dto) {
		
		return sessionTemplate.insert("mybatis.GuestMapper.input",dto);
	}
	
	// 글 목록
	public List<GuestDTO> list(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sessionTemplate.selectList("mybatis.GuestMapper.list",map);
	}
	
	// 총 글수
	public int totalA() {
		
		return sessionTemplate.selectOne("mybatis.GuestMapper.totalA");
	}
}
