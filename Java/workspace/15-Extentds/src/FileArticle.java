
public class FileArticle extends Article {
	// �ڷ��� Ȯ�� --> ���� �̸�
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "FileArticle [fileName=" + fileName + ", �۹�ȣ =" + getNum() + ", ���� =" + getTitle() + "]";
	}

	
	
}
