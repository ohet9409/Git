
public class Rectangle extends Area {
	public double getArea() {
		return getBase() * getHeight();
	}

	@Override
	public String toString() {
		return "Rectangle [getBase()=" + getBase() + ", getHeight()=" + getHeight() + "]";
	}
	
}
