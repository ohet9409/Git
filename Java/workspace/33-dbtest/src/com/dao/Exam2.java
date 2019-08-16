package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class InsertTest {
	// 1. Driver ���Ȯ��
	public InsertTest() {	// �ڵ����� 1�� ȣ��
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ��� �Ϸ�");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ��� ����");
//			e.printStackTrace();
		}
	}

	// 2. Connection
	public Connection getConnection() {
		Connection conn = null;
		// localhost = 127.0.0.1(�� pc�� ��Ÿ����.)
		//                      ����Ŭ ��ǰ          ip    port sid
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // ����Ŭ ����̹��� ���
		String username = "jspexam"; // ���� �̸�
		String password = "m1234"; // ���� ��й�ȣ
		try {
			conn = DriverManager.getConnection(url, username, password);	// ����Ŭ�� ����
			System.out.println("���� ����");
		} catch (SQLException e) {
			System.out.println("���� ����");
//			e.printStackTrace();
		}
		return conn;
	}

	// 3. SQL �۾�ó��
	public void insertArticle() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		System.out.print("Ű �Է� : ");
		double height = sc.nextDouble();
		// DB ó��
		Connection conn = getConnection();
		PreparedStatement pstmt = null;		// sql���� ���� ����ϰ� ����Ŭ�� ��û�ϴ� �뵵
		int su = 0;
		String sql = "insert into dbtest values (?, ?, ?, sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);	// 1�� ���� ����
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			su = pstmt.executeUpdate(); // ���� : ó���� ������ ������ ���ϵ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {	// ������ ���� �ڵ�
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(su + "���� ���� ����� �����ϴ�");
	}
}

public class Exam2 {

	public static void main(String[] args) {
		InsertTest insertTest = new InsertTest();
		insertTest.insertArticle();
	}

}
