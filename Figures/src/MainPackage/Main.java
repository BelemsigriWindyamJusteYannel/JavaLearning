package MainPackage;

import OtherPackage.*;

public class Main {
	public static void main(String[] args) {
		Circle cercle = new Circle(new Point2D(2,5),8); 
		System.out.println("aera : " + cercle.area());
	}
}
