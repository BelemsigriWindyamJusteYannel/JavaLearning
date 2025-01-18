package modelsPackage;
import java.awt.*;

public class Line extends Figure{
	// Attributes 
	private int x1,y1,x2,y2;
	// Constructor
	public Line() {
		this.x1 = 1;
		this.y1 = 1;
		this.x2 = 1;
		this.y2 = 1;
		this.setColor(Color.black);
		this.setName("Line");
	};
	public Line(int x1,int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.setColor(Color.black);
		this.setName("Line");
	}
	// Methods
	// setters 
	public void setExtremity1(int x1, int y1) {
		this.x1 = x1;
		this.y1 = y1;
	}
	public void setExtremity2(int x2, int y2) {
		this.x2 = x2;
		this.y2 = y2;
	}
	//getters
	public Point getExtremity1() {
		return new Point(x1,y1);
	}
	public Point getExtremity2() {
		return new Point(x2,y2);
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawLine(x1, y1, x2, y2);
	};
	// containing function
	@Override
	public boolean contains (int x, int y) {
		return ((this.y2 - this.y1)/(this.x2 - this.x1) == (y - this.y1)/(x - this.x1));
	};
}
