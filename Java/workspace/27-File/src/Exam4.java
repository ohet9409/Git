import helper.FileHelper;

public class Exam4 {

	public static void main(String[] args) {
		String encType = "utf-8";
		String filePath = "myfile.txt";	// 27프로젝트에 만들어진다
		String content = "안녕하세요. 자바 프로그래밍";
		// 파일 저장
		boolean result = FileHelper.getInstance().writeString(filePath, content, encType);
	
		if(!result) {
			System.out.println("파일 저장에 실패했습니다.");
			return; // 종료 시킴
		}
		// 파일 읽기
		String str = FileHelper.getInstance().readString(filePath, encType);
		System.out.println(str);
	}

}
