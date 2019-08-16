package sample6;

import java.io.FileWriter;

public class FileOutput implements Outputter{
	private String filePath;	// 파일 경로 저장
	
	public void output(String message) throws Exception {
		FileWriter out = new FileWriter(filePath);
		out.write(message);
		out.close();
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	

}
