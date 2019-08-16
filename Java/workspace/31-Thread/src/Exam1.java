class ThreadExam1 extends Thread{
	@Override
	public void run() {
		System.out.println("Test thread 1");
		for(int x=0; x<100; x++) {
			System.out.println((char)(x+65));
		}
	}
}
public class Exam1 {

	public static void main(String[] args) {
		ThreadExam1 exam1 = new ThreadExam1();
		exam1.run();		// Thread 클래스 사용법 중, 함수 호출		
		exam1.start();		// Thread 클래스 사용법 중, 쓰레드로 시작시킴, 메인함수와 별개로 독립적으로 실행되어져서 순서가 정해지지 않는다.	
		System.out.println("Main thread");					  
		for(int x=0; x<500 ; x++) {
			System.out.println(x);
		}
	}

}
