
public class Exam3 {

	public static void main(String[] args) {
					//	0123456789012
		String jumin = "9006071123456";
		String y = jumin.substring(0, 2);
		String m = jumin.substring(2, 4);
		String d = jumin.substring(4, 6);
		String gender_code = jumin.substring(6,7);
		String gender = "";
		if(gender_code.equals("1") || gender_code.equals("3")) {
			gender = "남자";
		}else {
			gender = "여자";
		}
		if(gender_code.equals("1") || gender_code.equals("2")) {
			y="19"+y;
		}else {
			y="20"+y;
		}
		System.out.printf("%s년 %s월 %s일 %s", y,m,d,gender);
		
	}

}
