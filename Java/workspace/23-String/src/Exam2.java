
public class Exam2 {

	public static void main(String[] args) {
		String str = "student@java.com";
		int pos = str.indexOf("@");	// "@"위치값 구하기
		String id= str.substring(0, pos); //"@"전 문자까지 자른다
		String domain= str.substring(pos+1); // "@" 이후 문자를 자른다
		System.out.println("id : "+id);
		System.out.println("domain : "+domain);
	}

}
