class TreadExam2 implements Runnable {
	@Override
	public void run() {
		System.out.println("Test tread 2");
		
	}
}

public class Exam2 {
	public static void main(String[] args) {
		TreadExam2 exam2 = new TreadExam2();
		Thread thread = new Thread(exam2);
		thread.start();						// ���������� ����
		System.out.println("main Thread");
		for(int x=0; x<500 ; x++) {
			System.out.println(x);
		}
	}
}

