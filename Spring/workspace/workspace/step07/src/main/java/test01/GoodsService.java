package test01;

import java.util.List;


// ~Service 클래스의 역할 : 여러개의 DAO를 묶어서 관리할 때 사용
public interface GoodsService {
	/* CRUD 기능의 메소드 */
	// 책등록
	int insertGoods(GoodsVO vo);
	// 책수정
	int updateGoods(GoodsVO vo);
	// 책삭제
	int deleteGoods(GoodsVO vo);
	// 책 상세조회
	GoodsVO getGoods(GoodsVO vo);
	// 책 목록조회
	List<GoodsVO> getGoodsList();
}








