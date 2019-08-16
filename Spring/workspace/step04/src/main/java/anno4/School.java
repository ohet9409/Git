package anno4;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class School {
	//@Autowired
	@Resource	//@Autowired + @Qualifier
	public Student student1;
	//@Resource(name="grade")
	@Autowired
	public int grade;
	@Override
	public String toString() {
		return "School [person=" + student1 + ", grade=" + grade + "]";
	}
	
}
