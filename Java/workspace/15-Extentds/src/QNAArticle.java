
public class QNAArticle extends Article{
	// �θ� Ŭ������ title�� �������� ����, �亯�� �߰��Ѵ�.
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "QNAArticle [answer=" + answer + ", �۹�ȣ =" + getNum() + ", ���� =" + getTitle() + "]";
	}
	
}
