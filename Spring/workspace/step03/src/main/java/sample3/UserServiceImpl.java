package sample3;

public class UserServiceImpl implements UserService{
	// 싱글톤 패턴 시작
	private static UserServiceImpl instance = null;
	
	public static UserServiceImpl getInstance() {
		if(instance == null) instance = new UserServiceImpl();
		return instance;
	}
	public UserServiceImpl() {
		System.out.println("UserServiceImpl() 호출");
	}
	// 싱글톤 패턴 끝
	
	public void addrUser(UserVo vo) {
		System.out.println("addrUser(UserVo vo) 호출");
		System.out.println("이름 : " + vo.getUserName());
		
	}

}
