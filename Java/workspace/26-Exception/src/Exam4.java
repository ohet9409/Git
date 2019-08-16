
public class Exam4 {
	public static void main(String[] args) {

		int[] arr = new int[3];
		try {
			for (int x = 0; x <= 3; x++) {
				arr[x] = x;
				System.out.println(arr[x]);
			}
		} catch (Exception e) {
			System.out.println("에러가 발생했습니다.");
			System.out.println("원인 : " + e.getMessage());
		}
		finally {
			System.out.println("에러가 생기든, 생기지 않든 실행할 명령어");
		}
		System.out.println("--- 프로그램을 종료합니다. ---");

	}
}
