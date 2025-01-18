package OtherPackage;

public class Circle extends Shape{
	double radius;
	//Constuctor
	public double area() {
		return radius * radius * Math.PI;
	}
	public Circle(){
		radius = 1;
	}
	public Circle(Point2D point, double rayon){
		super(point);
		this.radius = rayon;
	}
	public void println() {
		super.print("Circle");
		System.out.println("radius : " + radius);
	}
}
