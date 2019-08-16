package com.dao;
//자바빈즈
public class Dto {
	private String name;	// 이름
	private String value;	// 학번, 부서, 과목
	private int code;		// 코드 1: 학생     2: 교수   3: 관리자
	private int rank;
	
	public Dto() {
		super();
	}
	public Dto(String name, String value, int code, int rank) {
		super();
		this.name = name;
		this.value = value;
		this.code = code;
		this.rank = rank;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Dto [name=" + name + ", value=" + value + ", code=" + code + ", rank=" + rank + "]";
	}
	
	
}
