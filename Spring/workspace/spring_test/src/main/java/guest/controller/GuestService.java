package guest.controller;

import java.util.List;

import guest.bean.GuestDTO;

public interface GuestService {
	int input(GuestDTO dto);
	List<GuestDTO> list(int startNum, int endNum);
	int totalA();
}
