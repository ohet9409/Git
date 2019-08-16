
public class Exam3 {

	public static void main(String[] args) {
		// 무명 클래스 사용방법1
//		Thread thread = new Thread() {
//			@Override
//			public void run() {
//				System.out.println("Test thread 3");
//			}
//		};
//		thread.start();
		// 무명 클래스 사용방법2
		(new Thread() {
			@Override
			public void run() {
				System.out.println("Test thread 3");
			}
		}).start();
		
		System.out.println("Main thread");
		for(int x=0; x<500 ; x++) {
			System.out.println(x);
		}

	}

}
