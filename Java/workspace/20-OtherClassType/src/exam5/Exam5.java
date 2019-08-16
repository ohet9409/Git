package exam5;
public class Exam5 {

	public static void main(String[] args) {
		// 게시판의 기능 정의
		Mysite bbs = new Mysite() {
			@Override
			public void write() {
				System.out.println("새 글 쓰기");

			}

			@Override
			public void delete() {
				System.out.println("글 삭제");

			}
		};
		bbs.write();
		bbs.delete();
		// 회원 관리의 기능 정의
		Mysite member = new Mysite() {

			public void write() {
				System.out.println("회원 가입");
			}

			public void delete() {
				System.out.println("회원 탈퇴");
			}
		};
		member.write();
		member.delete();
	}

}
