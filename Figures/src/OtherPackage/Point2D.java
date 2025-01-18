package OtherPackage;

public class Point2D {
	double x,y;
	public Point2D(){
		x = 0;
		y = 0;
	}
	public Point2D(double x,double y){
		this.x = x;
		this.y = y;
	}
	public void print() {
		System.out.println("[" + x + ";" + y + "]");
	}
}
