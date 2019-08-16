
public class Exam2 {
	public static void main(String[] args) {
		/** 성적 처리에 대한 2차원 배열 생성 */
		// 학급 성적을 위한 배열
		int[][] grade = new int[3][3];
		String[] name = { "홍길동", "김철수", "이영희" };

		// 홍길동의 과목별 점수
		grade[0][0] = 75;
		grade[0][1] = 82;
		grade[0][2] = 95;
		// 김철수의 과목별 점수
		grade[1][0] = 88;
		grade[1][1] = 64;
		grade[1][2] = 70;
		// 이영희의 과목별 점수
		grade[2][0] = 100;
		grade[2][1] = 95;
		grade[2][2] = 90;
		/** 2차원 배열을 탐색하여 총점과 평균점수 구하기 */
		for (int x = 0; x < grade.length; x++) { // 행의 개수
			int sum = 0;
			double avg = 0;
			for (int y = 0; y < grade[x].length; y++) { // 열의 개수
				sum += grade[x][y];
			}
			avg = (double) sum / grade[x].length;
			System.out.println(name[x] + ", 총점= " + sum + ", 평균= " + avg);
		}
	}
}
