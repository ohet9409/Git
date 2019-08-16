package test02;

import org.springframework.context.support.GenericXmlApplicationContext;



public class JdbcExample2 {

	public static void main(String[] args) {
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("applicationContext.xml");
		GoodsService service = (GoodsService) context.getBean("goodsService");
		GoodsVO vo = new GoodsVO();
		vo.setCode("p002");
		int result = service.deleteGoods(vo);
		if(result >0) {
			System.out.println(vo.getCode()+"교재가  삭제 되었습니다");
		} else {
			System.out.println("삭제실패");
		}
		context.close();

	}

}
