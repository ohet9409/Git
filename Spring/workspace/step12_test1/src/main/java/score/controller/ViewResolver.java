package score.controller;

public class ViewResolver {
	private String prefix;
	private String suffix;
	
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
