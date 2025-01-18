package OtherPackage;

public class Square extends Shape{
	double width;
	@Override 
	public double area() {
		return width*width;
	}
	public Square() {
		width = 1;
	}
	public Square(Point2D point,double width) {
		super(point);
		this.width = width;
	}
	public void println() {
		super.print("Square");
		System.out.println("width : " + width);
	}
}
