
public class Exam4 {

	public static void main(String[] args) {
		// ���� Ŭ���� �����1
//		Runnable runnable = new Runnable() {
//			
//			@Override
//			public void run() {
//				System.out.println("Test thread 4");
//				
//			}
//		};
//		Thread thread = new Thread(runnable);
//		thread.start();
		// ���� Ŭ���� �����2
//		Runnable runnable = new Runnable() {
//
//			@Override
//			public void run() {
//				System.out.println("Test thread 4");
//			}
//		};
//		(new Thread(runnable)).start();
		// ���� Ŭ���� �����3
		(new Thread( new Runnable() {

			@Override
			public void run() {
				System.out.println("Test thread 4");
			}
		})).start();
		System.out.println("Main thread");
		for (int x = 0; x < 500; x++) {
			System.out.println(x);
		}
	}

}
