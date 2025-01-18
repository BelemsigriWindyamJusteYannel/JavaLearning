package modelsPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends Figure {
	// Attributes
	private int x,y,radius;
	// Constructor
	public Circle(){
		this.x = 1;
		this.y = 1;
		this.setColor(Color.black);
		this.setName("Circle");
	};
	public Circle(int x, int y , int radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.setColor(Color.black);
		this.setName("Circle");
	};
	// Methods
	// setters
	public void setLocation(int x1, int y1) {
		this.x = x1;
		this.y = y1;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	//getters
	public Point getLocation() {
		return new Point(x,y);
	}
	public int getRadius() {
		return radius;
	}
	// Drawing function 
	@Override
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawOval(x-radius,y-radius, radius * 2, radius * 2);
	};
	// containing function
	@Override
	public boolean contains (int x, int y) {
		return ((Math.pow(x-this.x,2)+Math.pow(y-this.y,2)) <= Math.pow(radius, 2));
	};
}
