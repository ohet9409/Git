package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO dao;
	@Override
	public int boardWrite(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return dao.boardWrite(boardDTO);
	}

	@Override
	public List<BoardDTO> boardList(int startNum, int endNum) {
		// TODO Auto-generated method stub
		return dao.boardList(startNum, endNum);
	}

	@Override
	public BoardDTO boardView(int seq) {
		// TODO Auto-generated method stub
		return dao.boardView(seq);
	}

	@Override
	public int getTotalA() {
		// TODO Auto-generated method stub
		return dao.getTotalA();
	}

	@Override
	public int updateHit(int seq) {
		// TODO Auto-generated method stub
		return dao.updateHit(seq);
	}

	@Override
	public int boardDelete(int seq) {
		// TODO Auto-generated method stub
		return dao.boardDelete(seq);
	}

	@Override
	public int boardModify(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return dao.boardModify(boardDTO);
	}

}
