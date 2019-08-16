
public class Exam5 {
	public static void main(String[] args) {
		Article article = new Article();
//		article.seq=1;
//		article.subject = 'java';
		article.setSeq(1);
		article.setSubject("java");
		article.setContent("클래스 중심의 언어");
		System.out.println(article.getSeq());
		System.out.println(article.getSubject());
		System.out.println(article.getContent());
		
		// 클래스 배열 (나중에 설명)
		Article[] articles;
		articles = new Article[3];
		articles[0] = new Article();
		articles[1] = new Article();
		articles[2] = new Article();
	}
}
