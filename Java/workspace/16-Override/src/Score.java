
public class Score {
	String name;
	int kor, eng, mat;
	int tot;
	double avg;
	
	public Score(String name, int kor, int eng, int mat) {	// »ý¼ºÀÚ
		this.name =name;
		this.eng = eng;
		this.kor = kor;
		this.mat = mat;
	}
	public int calc_tot() {
		tot = kor + eng + mat;
		return tot;
	}
	public double calc_avg() {
		avg = (double)tot/3;
		return avg;
	}
	public void output_result() {
		System.out.println("ÀÌ¸§ : " + name + ", ÃÑÁ¡ : " + calc_tot() + 
				", Æò±Õ : " + calc_avg());
	}
}
