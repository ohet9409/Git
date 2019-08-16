import prac1.DrawData;
import prac1.IsoTriangle;
import prac1.Pyramid;

public class Prac1 {

	public static void main(String[] args) {
		DrawData drawData;
		
		drawData = new IsoTriangle();
		drawData.setHeight(10);
		drawData.setOutchar('x');
		drawData.draw();
		
		drawData = new Pyramid();
		drawData.setHeight(10);
		drawData.setHeight('#');
		drawData.draw();
	}

}
