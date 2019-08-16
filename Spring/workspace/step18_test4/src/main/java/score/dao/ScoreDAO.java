package score.dao;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import score.bean.ScoreDTO;

@Repository
public class ScoreDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 성적 입력
	public int scoreInput(ScoreDTO dto) {
		
		return sqlSession.insert("mybatis.scoreMapper.scoreInput",dto);
	}

	// 성적 삭제
	public int scoreDel(String studNo) {
		
		return sqlSession.delete("mybatis.scoreMapper.scoreDel",studNo);
	}

	// 성적 수정
	public int scoreUpdate(ScoreDTO dto) {
		
		return sqlSession.update("mybatis.scoreMapper.scoreUpdate",dto);
	}

	// 성적 보기
	public ScoreDTO scoreView(String studNo) {
		
		return sqlSession.selectOne("mybatis.scoreMapper.scoreView",studNo);
	}

	// 성적 목록
	public List<ScoreDTO> scoreList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.scoreMapper.scoreList",map);
	}
	// 총 글수
	public int scoreCount() {
		
		return sqlSession.selectOne("mybatis.scoreMapper.scoreCount");
	}

}
