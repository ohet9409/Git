
public class Article {
	int seq;
	private String subject;
	private String content;

	public Article() {
		
	}
	public Article(int seq, String subject, String content) {
		this.seq = seq;
		this.subject = subject;
		this.content = content;
	}
	// setter : ��������� �� ����
	public void setSeq(int seq) { // setter
		this.seq = seq;
	}

	// getter : ������� �� Ȯ��
	public int getSeq() { // getter
		return seq;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
