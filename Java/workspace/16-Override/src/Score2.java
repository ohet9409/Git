
public class Score2 extends Score{
	int mus, com;
	public Score2(String name, int kor, int eng, int mat, int mus, int com) {
		super(name, kor, eng, mat); // �θ� Ŭ������  ������ ȣ��
		this.mus = mus;
		this.com = com;
	}
	@Override // �θ� Ŭ���� ��ȿȭ, �θ��� �̸��� ���� �Լ��� �ִ��� �˻�
	public int calc_tot() {		// �θ� Ŭ���� �Լ� ����
		tot = super.calc_tot() +mus + com; // super. �Լ��� => �θ� Ŭ������ �Լ� ȣ��
		return tot;
	}
	@Override
	public double calc_avg() {	// �θ� Ŭ���� �Լ� ����
		avg = (double)tot/5;
		return avg;
	}
	@Override
	public void output_result() {	// �θ� Ŭ���� �Լ� ����
		System.out.println("�̸� : " + name + ", ���� : " + calc_tot() + ", ��� : " + calc_avg());
		
	}
}
