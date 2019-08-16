package test.service;

import java.util.List;

import test.bean.ScoreVO;

public interface ScoreService {
	/* CRUD 기능의 메소드 */
	// 성적 저장
	int insertScore(ScoreVO vo);
	// 성적 수정
	int updateScore(ScoreVO vo);
	// 성적 삭제
	int deleteScore(ScoreVO vo);
	// 성적 목록보기
	List<ScoreVO> getScoreList();
}











