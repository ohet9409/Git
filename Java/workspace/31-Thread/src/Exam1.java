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
		exam1.run();		// Thread Ŭ���� ���� ��, �Լ� ȣ��		
		exam1.start();		// Thread Ŭ���� ���� ��, ������� ���۽�Ŵ, �����Լ��� ������ ���������� ����Ǿ����� ������ �������� �ʴ´�.	
		System.out.println("Main thread");					  
		for(int x=0; x<500 ; x++) {
			System.out.println(x);
		}
	}

}
