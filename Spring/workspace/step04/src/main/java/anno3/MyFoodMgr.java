package anno3;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myFood")
public class MyFoodMgr {
	@Autowired
	@Qualifier(value="unFavoriteFood")
	private Food favoriteFood;
	//@Autowired
	//@Qualifier(value="favoriteFood")
	// @Resource : @Autowired + @Qualifier 
	//@Resource(name="favoriteFood")
	@Resource
	private Food unFavoriteFood;
	@Override
	public String toString() {
		return "MyFoodMgr [favoriteFood=" + favoriteFood + "\n unFavoriteFood=" + unFavoriteFood + "]";
	}
	public Food getFavoriteFood() {
		return favoriteFood;
	}
	public void setFavoriteFood(Food favoriteFood) {
		this.favoriteFood = favoriteFood;
	}
	public Food getUnFavoriteFood() {
		return unFavoriteFood;
	}
	public void setUnFavoriteFood(Food unFavoriteFood) {
		this.unFavoriteFood = unFavoriteFood;
	}
	
}
