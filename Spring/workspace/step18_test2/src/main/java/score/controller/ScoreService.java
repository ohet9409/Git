package score.controller;

import java.util.List;

import score.bean.ScoreDTO;

public interface ScoreService {
	int scoreInput(ScoreDTO dto);
	int scoreDel(String studNo);
	int scoreUpdate(ScoreDTO dto);
	ScoreDTO scoreView(String studNo);
	List<ScoreDTO> scoreList(int startNum, int endNum);
	 int scoreCount();
}
