import java.util.Calendar;

public class Exam3 {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		// 현재 시간에 대한 Time stamp를 밀리세컨 단위로 얻기
		long ms1= calendar.getTimeInMillis();
		System.out.println("시작 시간 >> " + ms1);
		
		// 프로그램을 주어진 시간동안 대기시킴
		try {	// 예외처리
			Thread.sleep(5000);	// 5초 대기 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		// time stamp 값을 얻는 또 다른 방법
		long ms2 = System.currentTimeMillis();
		System.out.println("종료 시간 >> " + ms2);
		// 두 시간의 차 얻기
		long result = ms2-ms1;
		System.out.println("result = " + result);
		System.out.println((double)result/1000+"초 지났음");
	}

}
