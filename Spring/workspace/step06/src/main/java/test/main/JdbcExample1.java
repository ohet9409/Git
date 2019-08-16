package test.main;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.bean.GoodsVO;
import test.service.GoodsService;

public class JdbcExample1 {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("applicationContext.xml");
		// 2. Spring 컨테이너로 부터, GoodsServiceImpl 객체를 얻는다.
		GoodsService service = (GoodsService) context.getBean("goodsServiceImpl");
		// 3. 책 등록 기능 사용
		GoodsVO vo = new GoodsVO();
		vo.setCode("p002");
		vo.setName("스프링의 일생");
		vo.setPrice(25000);
		vo.setMaker("마춤출판사");
		int result = service.insertGoods(vo);
		if(result >0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
		// 4. 책 목록 기능 사용
		List<GoodsVO> list = service.getGoodsList();
		for(GoodsVO goodsVO: list) {
			System.out.println(goodsVO.toString());
		}
		// 5. Spring 컨테이너 종료
		context.close();
	}

}
