package test4;

import java.util.Scanner;
// 데이터 처리의 크기 : 1명 -> 여러명(List) -> 여러명(파일저장) -> 여러명(DB)
public class SungjukImpl implements Sungjuk{
	Scanner sc = new Scanner(System.in);
	private SungjukDTO dto;
	


	public SungjukDTO getDto() {
		return dto;
	}

	

	public void setDto(SungjukDTO dto) {
		this.dto = dto;
	}

	@Override
	public void calcTot() {
		int total = dto.getKor() + dto.getEng() + dto.getMath();
		dto.setTot(total);
	}

	@Override
	public void calcAvg() {
		double avg = dto.getTot()/3.0;
		dto.setAvg(avg);
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		calcTot();
		calcAvg();
		System.out.println(dto.getName()+"\t" +  dto.getKor() + "\t" + dto.getEng()+ "\t"+dto.getMath()+"\t" + dto.getTot()+ "\t" +  dto.getAvg());
	}

	@Override
	public void modify() {
		System.out.print("이름 입력 : ");
		dto.setName(sc.next());
		System.out.print("국어 입력 : ");
		dto.setKor(sc.nextInt());
		System.out.print("영어 입력 : ");
		dto.setEng(sc.nextInt());
		System.out.print("수학 입력 : ");
		dto.setMath(sc.nextInt());
	}

}
