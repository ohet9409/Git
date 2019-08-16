package board.controller;
// JSP 파일이름 완성
public class ViewResolver {
	private String prefix;	// 접두사 => "./"
	private String suffix;	// 접미사 => ".jsp"
	// JSP 파일이름 완성시켜서 리턴
	// viewName ="boardList"
	// 리턴값 : "./boardList.jsp";
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
	
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	
}
