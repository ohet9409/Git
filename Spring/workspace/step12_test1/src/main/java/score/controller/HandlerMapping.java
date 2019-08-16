package score.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private Map<String, Controller> map;
	
	public HandlerMapping() {
		System.out.println("HandlerMapping() 호출");
		map = new HashMap<String, Controller>();
		map.put("/scoreWrite.do", new ScoreWriteController());
		map.put("/scoreWriteForm.do", new ScoreWriteFormController());
		map.put("/scoreList.do", new ScoreListController());
		map.put("/scoreView.do", new ScoreViewController());
		map.put("/scoreDelete.do", new ScoreDeleteController());
		map.put("/scoreUpdate.do", new ScoreUpdateController());
		map.put("/scoreUpdateForm.do", new ScoreUpdateFormController());
	}
	public Controller getController(String path) {
		System.out.println("getController(String path) 호출" + path);
		return map.get(path);
	}
}
