package sec01.variable;

public class variablescope {
	public static void main(String[] args) {
		int val1;
		
		if(true) {
			int var2;
			val1=10;
			var2=20;
		}
		val1=10;
		var2=20;
		
		for(int i=0;i<1;i++) {
			int var3;
			val1=10;
			var3=30;
		}
		val1=10;
		var3=10;
	}

}
