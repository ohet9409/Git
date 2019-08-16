
public class FileArticle extends Article {
	// 자료의 확장 --> 파일 이름
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "FileArticle [fileName=" + fileName + ", 글번호 =" + getNum() + ", 제목 =" + getTitle() + "]";
	}

	
	
}
