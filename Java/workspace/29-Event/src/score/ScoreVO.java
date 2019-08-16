package score;

import java.io.Serializable;

public class ScoreVO implements Serializable{
	private String hak;			// �й�
	private String name;		// �̸�
	private int kor, eng, mat;	// ����, ����, ����
	private int tot;			// ����
	private double avg;			// ���
	// ��� ������ ��¿�
	@Override
	public String toString() {
		if(hak == null || name == null) {
			return null;
		}
		String str = hak + "\t" +name + "\t"+ kor + "\t"+ eng + "\t" +mat + "\t"+ tot + "\t"+avg;
		return str;
	}
	public String getHak() {
		return hak;
	}
	public void setHak(String hak) {
		this.hak = hak;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
}
