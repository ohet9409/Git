import java.util.Calendar;

public class Exam3 {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		// ���� �ð��� ���� Time stamp�� �и����� ������ ���
		long ms1= calendar.getTimeInMillis();
		System.out.println("���� �ð� >> " + ms1);
		
		// ���α׷��� �־��� �ð����� ����Ŵ
		try {	// ����ó��
			Thread.sleep(5000);	// 5�� ��� 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		// time stamp ���� ��� �� �ٸ� ���
		long ms2 = System.currentTimeMillis();
		System.out.println("���� �ð� >> " + ms2);
		// �� �ð��� �� ���
		long result = ms2-ms1;
		System.out.println("result = " + result);
		System.out.println((double)result/1000+"�� ������");
	}

}
