package test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import test.bean.ScoreVO;
import test.dao.ScoreDAOSpring;
// @Service : bean 객체 처리
@Service
public class ScoreServiceImpl implements ScoreService{
	// @Repository로 bean객체 처리한 것을 불러온다.
	@Autowired
	private ScoreDAOSpring scoreDAO;
	
	@Override
	public int insertScore(ScoreVO vo) {
		return scoreDAO.insertScore(vo);
	}

	@Override
	public int updateScore(ScoreVO vo) {
		// TODO Auto-generated method stub
		return scoreDAO.updateScore(vo);
	}

	@Override
	public int deleteScore(ScoreVO vo) {
		// TODO Auto-generated method stub
		return scoreDAO.deleteScore(vo);
	}

	@Override
	public List<ScoreVO> listScore() {
		// TODO Auto-generated method stub
		return scoreDAO.listScore();
	}

	@Override
	public int menu() {
		return scoreDAO.menu();
	}

}
