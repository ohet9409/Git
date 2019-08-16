package sec01.variable;

public class litereal {
	public static void main(String[] args) {
		int val=10;
		System.out.println(val);
		
		int val2=010;
		System.out.println(val2);
		
		int val3=0x10;
		System.out.println(val3);
		
		double val4 =0.25;
		System.out.println(val4);
		
		double val5 =2e5;
		System.out.println(val5);
		
		char val6 ='a';
		System.out.println(val6);
		
		char val7 ='한';
		System.out.println(val7);
		
		System.out.println('\t' + "들여쓰기");
		System.out.println("대한" + '\n' + "민국");
		System.out.println("this" + "\'" + "s java");
		System.out.println("이것은" + "\'" + "중요"+ "\'"+" 합니다");
		System.out.println("가격이" + '\\' + "300입니다");
		
		char val8 ='\u0041';
		System.out.println(val8);
		
		System.out.println("대한"+"민국");
		System.out.println("java"+ 8);
		
		String val9="자바";
		
		boolean val10=true;
		boolean val11=false;
		System.out.println(val10);
	}

}
