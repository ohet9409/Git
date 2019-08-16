package test01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDAO goodsDAOSpring;

	@Override
	public int insertGoods(GoodsVO vo) {
		
		return goodsDAOSpring.insertGoods(vo);
	}

	@Override
	public int updateGoods(GoodsVO vo) {
		
		return goodsDAOSpring.updateGoods(vo);
	}

	@Override
	public int deleteGoods(GoodsVO vo) {
		
		return goodsDAOSpring.deleteGoods(vo);
	}

	@Override
	public GoodsVO getGoods(GoodsVO vo) {
		
		return goodsDAOSpring.getGoods(vo);
	}

	@Override
	public List<GoodsVO> getGoodsList() {
		
		return goodsDAOSpring.getGoodsList();
	}

}
