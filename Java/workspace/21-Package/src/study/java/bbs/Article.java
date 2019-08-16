package study.java.bbs;

public class Article {
	// static 변수 : 모든 객체가 공통으로 사용
	private static int count = 0;	// 전체 게시물 수 저장	
	private static String category;	// 게시물 분류 저장
	private int num;		// 글 번호
	private String title;	// 글 제목
	private String regData;	// 작성일시
	/**
	 * 생성자 : 멤버변수 초기화
	 * @param num : 글 번호
	 * @param title : 글 제목
	 * @param regData : 작성일시
	 */
	public Article(int num, String title, String regData) {
		super();
		this.num = num;
		this.title = title;
		this.regData = regData;
		count++;	// 게시물 신규등록 수 
	}
	/**
	 * 모든 멤버변수 내용 확인
	 */
	@Override
	public String toString() {
		return "글분류=" + category + ", 전체 글 수 = " + count + ", Article [num=" + num + ", title=" + title + ", regData=" + regData + "]";
	}

	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Article.count = count;
	}
	public static String getCategory() {
		return category;
	}
	public static void setCategory(String category) {
		Article.category = category;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegData() {
		return regData;
	}
	public void setRegData(String regData) {
		this.regData = regData;
	}
	
}
