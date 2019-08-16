
public class arra {

	public static void main(String[] args) {
		/*int[][] mathsc= new int[2][3];
		for(int i=0; i<mathsc.length;i++) {
			for(int k=0;k<mathsc[i].length;k++) {
				System.out.println("scoresMath["+ i + "]["+k+"]= "+mathsc[i][k]);
			}
		}
		System.out.println();
		
		int[][] engsc=new int[2][];
		engsc[0]=new int[2];
		engsc[1]=new int[3];
		for(int i=0; i<engsc.length;i++) {
			for(int k=0;k<engsc[i].length;k++) {
				System.out.println("engsc["+ i + "]["+k+"]= "+engsc[i][k]);
			}
		}
		System.out.println();
		
		int[][] sc= {{95,80}, {92,96,80}};
		for(int i=0; i<sc.length;i++) {
			for(int k=0;k<sc[i].length;k++) {
				System.out.println("engsc["+ i + "]["+k+"]= "+sc[i][k]);
			}
		}*//*
		String[] sarray=new String[3];
		sarray[0]="java";
		sarray[1]="java";
		sarray[2]=new String("java");
		
		System.out.println(sarray[0] == sarray[1]);
		System.out.println(sarray[0] == sarray[2]);
		System.out.println(sarray[0].equals(sarray[2]));*/
		/*
		int[] old = {1,2,3};
		int[] newi = new int[5];
		for(int i=0; i<old.length;i++) {
			newi[i]=old[i];
		}
		for(int i=0; i<newi.length;i++) {
			System.out.println(newi[i]);
		}*//*
		
		String[] oldi= {"java","array","copy"};
		String[] newi=new String[5];
		
		System.arraycopy(oldi,0,newi,0,oldi.length); 
		for(int i=0; i<newi.length;i++) {
			System.out.println(newi[i]);
		}*/
		
		int[] scorces= {95,71,84,93,87};
		int sum=0;
		for(int scorce: scorces) {
			sum+=scorce;
			
		}
		System.out.println("점수 종합: "+sum);
		double avg=(double)sum/scorces.length;
		System.out.println("평균: "+avg);
	}

}
