
public class boo {

	public static void main(String[] args) {
		/*boolean play = true;
		System.out.println(play);
		
		play =!play;
		System.out.println(play);

		play =!play;
		System.out.println(play);*/
		
		int v1=10;
		int v2=~v1;
		int v3=~v1+1;
		System.out.println(toBinaryString(v1) + " (½ÊÁø¼ö:" + v1 + ")" );
		System.out.println(v2);
		System.out.println(v3);
		
		int v4=-10;
		int v5=~v4;
		int v6=~v4+1;
		System.out.println(v5);
		System.out.println(v6);
		
		
	}

	private static String toBinaryString(int value) {
		String str = Integer.toBinaryString(value);
		while(str.length()<32) {
			str ="0" +str;
		}
		
		return str;
	}

}
