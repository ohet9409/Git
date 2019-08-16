package score;



// 인터페이스 용도
// 1. 어떤 함수를 상속받는 자식클래스에게 강제적으로 만들게 하고 싶을 때
// 2. 목차 역할
public interface Score {
	// 입력
	public void input();
	public void readFile();		// 파일 읽어오기
	// 연산
	public void searchHak();	// 학번 검색
	public void searchName();	// 이름 검색
	public void descSortTot();	// 정렬 : 총점, 내림차순
	public void ascSortHak();	// 정렬 : 학번, 오름차순
	
	// 출력
	public void printTitle();
	public void print();
	public void writeFile();	// 파일 저장하기
	public void pgmEnd();		// 프로그램 종료
	
	
}
