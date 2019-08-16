package customer_1;

public interface Customer {
	// 입력
	public void input();		// 고객 1명 데이터 입력
	// 연산
	public void searchNo();		// 검색 : 고객번호 기준으로 검색
	public void searchName();	// 검색 : 고객명 기준으로 검색
	public void descSortName();	// 정렬 : 이름, 내림차순
	public void ascSortNo();	// 정렬 : 고객번호, 오름차순
	// 출력
	public void printTitle();	// 제목 출력
	public void print();		// 내용 출력
	public void read();
	public void write();
}
