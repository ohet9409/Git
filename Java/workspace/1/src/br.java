
public class br {

	public static void main(String[] args) {
		/*
		outter: for(char upper='A'; upper<='Z';upper++) {
			
			for(char lower='a';lower<='z';lower++) {
				System.out.println(upper+"_"+lower);
				if(lower=='g') {
					break outter;
				}
			}
		}
		for(int i=1; i<=10; i++) {
			if(i%2!=0) {
				continue;
			}
			System.out.println(i);
		}
		int sum=0;
		for(int i=1; i<=100;i++) {
			if(i%3==0) {
				sum=sum+i;
			}
		}
		System.out.print("3의 배수의 합: "+sum);
		
		while(true) {
			int num1=(int)(Math.random()*6)+1;
			int num2=(int)(Math.random()*6)+1;
			System.out.println("(" + num1 + ","+num2+")");
			if((num1+num2)==5) {
				break;
			}
		}
		for(int x=1;x<=10;x++) {
			for(int y=1;y<=10;y++) {
				if((4*x+5*y)==60) {
					System.out.println("("+x+","+y+")");
				}
			}
		}*/
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
				if(i==j) {
					System.out.println();
				}
			}
		}
	}

}
