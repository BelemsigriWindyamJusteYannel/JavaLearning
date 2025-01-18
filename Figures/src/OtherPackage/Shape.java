package OtherPackage;

public abstract class Shape {
	Point2D center;
	//Abstract method
	public abstract double area();
	public Shape() {new Point2D();} // Here we call the constructor of Point2D class
	public Shape(Point2D center) {
		this.center = center;
	}
	void Move(Vector2D vec) {
		center.x += vec.x;
		center.y += vec.y;
	}
	
	void Move(double x, double y) {
		center.x +=x;
		center.y +=y;
	}
	//Horizontal
	void MoveH(double x) {
		center.x += x;
	}
	
	//Vertical
	void MoveV(double y) {
		center.y += y;
	}
	//Printing method
	public void print(String nature) {
		System.out.println("Object : " + nature 
				+"centre : ");
		center.print();
	}
	public void println() {
		print("Shape");
	}
}
