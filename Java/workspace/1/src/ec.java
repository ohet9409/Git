import java.util.Scanner;

public class ec {

	public static void main(String[] args) {/*
		boolean run=true;
		int balance=0;
		Scanner scanner= new Scanner(System.in);
		while(run) {
			System.out.println("-------------------");
			System.out.println("1.���� | 2.���| 3.�ܰ�| 4.����");
			System.out.println("-------------------");
			System.out.println("����> ");
			int menuNum = scanner.nextInt();
			switch(menuNum) {
			case 1:
				System.out.print("���ݾ�>");;
				balance += scanner.nextInt();
				break;
			case 2:
				System.out.print("��ݾ�>");;
				balance -= scanner.nextInt();
				break;
			case 3:
				System.out.print("�ܰ�>");;
				System.out.println(balance);
				break;
			case 4:
				run=false;
				break;
			}
			
		}
			System.out.println("���α׷� ����");
	}
		String strV1="�Ź�ö";
		String strv2="�Ź�ö";
		
		if(strV1==strv2) {
			System.out.println("strV1�� strV2�� ������ ����");
					
		}else {
			System.out.println("strV1�� strV2�� ������ �ٸ�");
		}
		
		String strV3=new String("�Ź�ö");
		String strv4=new String("�Ź�ö");
		
		if(strV3==strv4) {
			System.out.println("strV1�� strV2�� ������ ����");
					
		}else {
			System.out.println("strV1�� strV2�� ������ �ٸ�");
		
		}
		if(strV1.equals(strv4)) {
			System.out.println("strV1�� strV2�� ���ڿ��� ����");
		
	}else {
		System.out.println("strV1�� strV2�� ���ڿ��� �ٸ�");
	
	}
		int[] scorce = {80,90,87};
		System.out.println("scorce[0]: "+ scorce[0]);
		System.out.println("scorce[1]: "+ scorce[1]);
		System.out.println("scorce[2]: "+ scorce[2]);
		
		int sum=0;
		for(int i=0; i<3; i++) {
			sum +=scorce[i];
		}
		System.out.println("����: "+ sum);
		
		double avg =(double)sum/3;
		System.out.println("���: "+ avg);*/
		/*
		int[] scorce;
		scorce= new int[] {83,90,87};
		
		int sum1=0;
		for(int i=0; i<3;i++) {
			sum1+=scorce[i];
		}
		System.out.println("����: "+ sum1);
		
		int sum2 = add(new int[]{83,90,87});
		System.out.println("����: "+ sum2);
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
	arr3[0]="1��";
	arr3[1]="2��";
	arr3[2]="3��";
	for(int i=0; i<3; i++) {
		System.out.println("arr3["+i+"]:"+arr3[i]);
	}*/
		int[] scorce= {83,90,87};
		
		int sum	=0;
		for(int i=0;i<scorce.length;i++) {
			sum+=scorce[i];
		}
		System.out.println("����: "+sum);
		double avg=(double)sum/scorce.length;
		System.out.println("���: "+avg);
		
	}
	
}
	


