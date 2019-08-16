package sample4;

import java.util.Calendar;

abstract public class AbstractTest {
	abstract public String dayInfo();
	
	public static AbstractTest getInstance() {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		
		switch(day) {
		case 1: return new Sunday();
		case 2: return new Monday();
		case 3: return new Tuesday();
		case 4: return new Wednesday();
		case 5: return new Thursday();
		case 6: return new Friday();
		case 7: return new Saturday();
		}
		return null;
		
	}
}
