
public class QNAArticle extends Article{
	// 부모 클래스의 title을 질문으로 보고, 답변을 추가한다.
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "QNAArticle [answer=" + answer + ", 글번호 =" + getNum() + ", 질문 =" + getTitle() + "]";
	}
	
}
