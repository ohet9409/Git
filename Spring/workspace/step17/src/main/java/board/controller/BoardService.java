package board.controller;

import java.util.List;

import board.bean.BoardDTO;

public interface BoardService {
	// 	CRUD 기능의 메소드
	int boardWrtie(BoardDTO boardDTO);
	int boardModify(BoardDTO boardDTO);
	int boardDelete(int seq);
	BoardDTO boardView(int seq);
	List<BoardDTO> boardList(int startNum, int endNum);
	int countHit(int seq);
	int count();
}
