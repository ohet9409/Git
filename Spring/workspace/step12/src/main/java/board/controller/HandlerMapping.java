package board.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private Map<String, Controller> map;
	
	public HandlerMapping() {
		map = new HashMap<String, Controller>();
		map.put("/login.do", new Logincontroller() );
		map.put("/boardList.do", new BoardListController() );
		map.put("/boardView.do", new BoardViewController());
		map.put("/boardDelete.do", new BoardDeleteController());
		map.put("/boardWrite.do", new BoardWriteController());
		map.put("/boardWriteForm.do", new BoardWriteFormController());
	}
	public Controller getController(String path) {
		return map.get(path);
	}
}
