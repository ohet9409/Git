
public class fore {

	public static void main(String[] args) {
		/*for(int i=1; i<=10; i++) {
			System.out.println(i);
		}
		int sum=0;
		int i=0;
		for(i=1;i<=100;i++) {
			sum=sum+i;
		}
		System.out.println("1-"+(i-1)+" 까지의 합: " +sum);
		for(float x=0.1f;x<=1.0f;x+=0.1f) {
			System.out.println(x);
		}*/
		for(int m=2;m<=9;m++) {
			System.out.println("****** "+m+"단 *****");
			for(int n=1;n<=9;n++) {
				System.out.println(m +"*"+ n + "=" + (m*n));
			}
		}
	}

}
