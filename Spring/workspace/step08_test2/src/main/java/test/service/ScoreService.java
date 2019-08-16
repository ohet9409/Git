package test.service;

import java.util.List;

import test.bean.ScoreVO;

public interface ScoreService {
	/* CRUD 기능의 메소드 */
	// 점수 등록
	int insertScore(ScoreVO vo);
	// 점수 수정
	int updateScore(ScoreVO vo);
	// 점수 삭제
	int deleteScore(ScoreVO vo);
	// 점수 목록조회
	List<ScoreVO> listScore();
	// 메뉴
	int menu();
}
