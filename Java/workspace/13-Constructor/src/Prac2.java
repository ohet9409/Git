class Address{
	String name, phone, add;
	Address(String name, String phone, String add){	// 생성자 생성
		this.name = name;
		this.phone = phone;
		this.add = add;
	}
	void showAddress(){
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phone);
		System.out.println("주소 : " + add);
	}
}
public class Prac2 {
	public static void main(String[] args) {
		Address a1;
		a1 = new Address("홍길동", "010-1234-5678", "서울시 강남구 역삼동"); // 생성자의 데이터 전달
		a1.showAddress();	// Address클래스에서 함수를 실행시킴
	}
}
