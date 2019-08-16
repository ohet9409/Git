
public class Score2 extends Score{
	int mus, com;
	public Score2(String name, int kor, int eng, int mat, int mus, int com) {
		super(name, kor, eng, mat); // 부모 클래스의  생성자 호출
		this.mus = mus;
		this.com = com;
	}
	@Override // 부모 클래스 무효화, 부모의 이름이 같은 함수가 있는지 검사
	public int calc_tot() {		// 부모 클래스 함수 수정
		tot = super.calc_tot() +mus + com; // super. 함수명 => 부모 클래스의 함수 호출
		return tot;
	}
	@Override
	public double calc_avg() {	// 부모 클래스 함수 수정
		avg = (double)tot/5;
		return avg;
	}
	@Override
	public void output_result() {	// 부모 클래스 함수 수정
		System.out.println("이름 : " + name + ", 총점 : " + calc_tot() + ", 평균 : " + calc_avg());
		
	}
}
