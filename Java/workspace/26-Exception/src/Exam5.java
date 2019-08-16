
public class Exam5 {

	public static void main(String[] args) {
		// 사용자의 입력값
		String[] src = { "5", "2", "7", "3" };
		// src 내용들을 숫자로 변환해서 저장할 배열
		int[] arr = new int[3];
		try {
			for (int x = 0; x < src.length; x++) {
				arr[x] = Integer.parseInt(src[x]);
				System.out.println(arr[x]);
			}

		} catch (NumberFormatException e) {
			System.out.println("문자열은 정수로만 구성되어져야 합니다..");
			System.out.println("원인 : " + e.getMessage());
//			e.printStackTrace();
//			System.out.println("에러가 발생했습니다.");

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 크기가 오버되었습니다.");
//			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("알수없는 에러입니다.");
		}
		System.out.println("--- 프로그램을 종료합니다. ---");
	}

}
