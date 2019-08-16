package guest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import guest.bean.GuestDTO;
import guest.dao.GuestDAO;
@Service
public class GuestServiceImpl implements GuestService{
	@Autowired
	private GuestDAO dao;
	@Override
	public int input(GuestDTO dto) {
		// TODO Auto-generated method stub
		return dao.input(dto);
	}

	@Override
	public List<GuestDTO> list(int startNum, int endNum) {
		// TODO Auto-generated method stub
		return dao.list(startNum, endNum);
	}

	@Override
	public int totalA() {
		// TODO Auto-generated method stub
		return dao.totalA();
	}

}
