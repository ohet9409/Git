package sample2;

public class Foo implements InterFoo{
	public Foo() {
		System.out.println("Foo 객체 생성 : Foo() 호출");
		System.out.println("-------------------------------------------------");
	}
	public Foo(String str) {
		System.out.println("Foo 객체 생성 : Foo(String str) 호출");
		System.out.println("str = " + str);
		System.out.println("-------------------------------------------------");
	}
	public Foo(String str, int num) {
		System.out.println("Foo 객체 생성 : Foo(String str, int num) 호출");
		System.out.println("num = " + num);
		System.out.println("str = " + str);
		System.out.println("-------------------------------------------------");
	}

	/*
	 * public Foo(String str, String num) {
	 * System.out.println("Foo 객체 생성 : Foo(String str, double num) 호출");
	 * System.out.println("num = " + num); System.out.println("str = " + str);
	 * System.out.println("-------------------------------------------------"); }
	 */
	public Foo(String str, int num, Boolean flag) {
		System.out.println("Foo 객체 생성 : Foo(String str, int num, Boolean flag) 호출");
		System.out.println("num = " + num);
		System.out.println("str = " + str);
		System.out.println("flag = " + flag);
		System.out.println("-------------------------------------------------");
	}
	public Foo(Bar bar) {
		System.out.println("Foo 객체 생성 : Foo(Bar bar) 호출");
		System.out.println("bar = " + bar);
		System.out.println("-------------------------------------------------");
	}
}
