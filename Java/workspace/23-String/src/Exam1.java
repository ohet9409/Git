
public class Exam1 {

	public static void main(String[] args) {
		// String 객체의 생성 방법
		String str1 = "자바 Programming";
		String str2 = new String("java");
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("------------------");
		// 1) 문자열의 길이를 조회
		int str1_len = str1.length();
		System.out.println("str1_len : " + str1_len);	// 공백도 글자수에 포함
		// 2) 특정 문자열이 처음으로 나타나는 위치를 조회
		int str1_pos = str1.indexOf("Pro");				// 문자열의 왼쪽에서 오른쪽으로 찾아감 (0부터 시작)
		System.out.println("str1_pos : " + str1_pos);
		// 3) 특정 문자열이 나타나는 마지막 위치를 조회
		int str1_last_pos = str1.lastIndexOf("g");		// 문자열의  오른쪽에서 왼쪽으로 찾아감 (0부터 시작)
		System.out.println("str1_last_pos : " +str1_last_pos);
		// 4) A를 B로 변경하기
		String new_str1 = str1.replace(" ", "_");
		System.out.println("new_str1 : " + new_str1);
		System.out.println("str1 : " + str1);			// 원본은 바뀌지 않는다
		// 5) 대소문자 변경
		String upper = str2.toUpperCase();
		System.out.println("upper : "+ upper);
		System.out.println("str2 : "+ str2);			// 원본은 바뀌지 않는다
		String lower = str2.toLowerCase();
		System.out.println("lower : "+ lower);
		System.out.println("str2 : "+ str2);
		// 6) 문자열의 앞뒤 공백 제거
		String input = "     enjoy java programming     ";
		String output = input.trim();
		System.out.println(input + "test");
		System.out.println(output + "test");
		// 7) 문자열의  비교하기
		boolean isSame = str1.equals(str2);			// 같으면 true  다르면 false
		if(isSame) System.err.println("같다!!");
		else System.out.println("다르다!!");
		// 8) 문자열의 자르기
		// 첫번째 매개변수 : 시작위치
		// 두번째 매개변수 : 끝위치
		String sub_str1 = str1.substring(0,2);
		String sub_str2 = str1.substring(3);
		int pos = str1.indexOf("P");
		String sub_str3 = str1.substring(pos, pos+3);
		System.out.println("str1 : " + str1);
		System.out.println("sub_str1 : " + sub_str1);
		System.out.println("sub_str2 : " + sub_str2);
		System.out.println("sub_str3 : " + sub_str3);
		// 9) 형식에 따른 문자열 출력을 위한 static 메소드 사용
		int yy = 2019;
		int mm = 4;
		int dd = 4;
		String gender = "남자";
		String result = String.format("%d년%d월%d일%s", yy,mm,dd,gender);
		System.out.println("result : " + result);
		// 10) 주어진 글자를 기준으로 잘라내어서 배열로 변환 
		String src = "C++/Java/C#/Javascript/Spring/Android";
		String[] data = src.split("/");
		for(int x=0; x<data.length;x++) {
			System.out.println(data[x]);
		}	}}
