import java.util.Scanner;

public class ec {

	public static void main(String[] args) {/*
		boolean run=true;
		int balance=0;
		Scanner scanner= new Scanner(System.in);
		while(run) {
			System.out.println("-------------------");
			System.out.println("1.예금 | 2.출금| 3.잔고| 4.종료");
			System.out.println("-------------------");
			System.out.println("선택> ");
			int menuNum = scanner.nextInt();
			switch(menuNum) {
			case 1:
				System.out.print("예금액>");;
				balance += scanner.nextInt();
				break;
			case 2:
				System.out.print("출금액>");;
				balance -= scanner.nextInt();
				break;
			case 3:
				System.out.print("잔고>");;
				System.out.println(balance);
				break;
			case 4:
				run=false;
				break;
			}
			
		}
			System.out.println("프로그램 종료");
	}
		String strV1="신민철";
		String strv2="신민철";
		
		if(strV1==strv2) {
			System.out.println("strV1과 strV2는 참조가 같음");
					
		}else {
			System.out.println("strV1과 strV2는 참조가 다름");
		}
		
		String strV3=new String("신민철");
		String strv4=new String("신민철");
		
		if(strV3==strv4) {
			System.out.println("strV1과 strV2는 참조가 같음");
					
		}else {
			System.out.println("strV1과 strV2는 참조가 다름");
		
		}
		if(strV1.equals(strv4)) {
			System.out.println("strV1과 strV2는 문자열이 같음");
		
	}else {
		System.out.println("strV1과 strV2는 문자열이 다름");
	
	}
		int[] scorce = {80,90,87};
		System.out.println("scorce[0]: "+ scorce[0]);
		System.out.println("scorce[1]: "+ scorce[1]);
		System.out.println("scorce[2]: "+ scorce[2]);
		
		int sum=0;
		for(int i=0; i<3; i++) {
			sum +=scorce[i];
		}
		System.out.println("총합: "+ sum);
		
		double avg =(double)sum/3;
		System.out.println("평균: "+ avg);*/
		/*
		int[] scorce;
		scorce= new int[] {83,90,87};
		
		int sum1=0;
		for(int i=0; i<3;i++) {
			sum1+=scorce[i];
		}
		System.out.println("총합: "+ sum1);
		
		int sum2 = add(new int[]{83,90,87});
		System.out.println("총합: "+ sum2);
	}
	public static int add(int[] scores) {
		int sum=0;
		for(int i=0;i<3;i++) {
			sum+=scores[i];
		}
		return sum;*//*
	int [] arr1 = new int[3];
	for(int i=0; i<3; i++) {
		System.out.println("arr1["+i+"]:"+arr1[i]);
	}
	System.out.println();
	arr1[0]=10;
	arr1[1]=20;
	arr1[2]=30;
	for(int i=0; i<3; i++) {
		System.out.println("arr1["+i+"]:"+arr1[i]);
	}
	System.out.println();
	double[] arr2 = new double[3];
	for(int i=0; i<3; i++) {
		System.out.println("arr2["+i+"]:"+arr2[i]);
	}
	System.out.println();
	arr2[0]=0.1;
	arr2[1]=0.2;
	arr2[2]=0.3;
	for(int i=0; i<3; i++) {
		System.out.println("arr2["+i+"]:"+arr2[i]);
	}
	System.out.println();
	String[] arr3 = new String[3];
	for(int i=0; i<3; i++) {
		System.out.println("arr3["+i+"]:"+arr3[i]);
	}
	System.out.println();
	arr3[0]="1월";
	arr3[1]="2월";
	arr3[2]="3월";
	for(int i=0; i<3; i++) {
		System.out.println("arr3["+i+"]:"+arr3[i]);
	}*/
		int[] scorce= {83,90,87};
		
		int sum	=0;
		for(int i=0;i<scorce.length;i++) {
			sum+=scorce[i];
		}
		System.out.println("총합: "+sum);
		double avg=(double)sum/scorce.length;
		System.out.println("평균: "+avg);
		
	}
	
}
	


