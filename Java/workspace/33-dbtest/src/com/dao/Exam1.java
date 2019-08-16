package com.dao;

public class Exam1 {

	public static void main(String[] args) {
		try {
			// OracleDriver 클래스가 프로젝트에 등록되어 있는지를 검사함
			// 없으면 예외발생함
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 등록 실패");
//			e.printStackTrace();
		}

	}

}
