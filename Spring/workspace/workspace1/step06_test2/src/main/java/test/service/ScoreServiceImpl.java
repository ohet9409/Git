package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.bean.ScoreVO;
import test.dao.ScoreDAO;

@Service
public class ScoreServiceImpl implements ScoreService{
	@Autowired
	private ScoreDAO scoreDAO;

	@Override
	public int insertScore(ScoreVO vo) {
		return scoreDAO.insertScore(vo);
	}
	@Override
	public int updateScore(ScoreVO vo) {
		return scoreDAO.updateScore(vo);
	}
	@Override
	public int deleteScore(ScoreVO vo) {
		return scoreDAO.deleteScore(vo);
	}
	@Override
	public List<ScoreVO> getScoreList() {
		return scoreDAO.getScoreList();
	}

}
