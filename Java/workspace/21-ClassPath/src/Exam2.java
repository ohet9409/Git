import study.java.bbs.Article;



public class Exam2 {

	public static void main(String[] args) {
		Article.setCategory("�����Խ���");
		Article a1 = new Article(1, "ù��° �� ����", "2019-01-01");
		Article a2 = new Article(2, "�ι�° �� ����", "2019-03-01");
		Article a3 = new Article(3, "����° �� ����", "2019-04-01");
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a3.toString());
	}

}
