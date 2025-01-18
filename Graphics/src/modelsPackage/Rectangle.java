package modelsPackage;
import java.awt.*;

public class Rectangle extends Figure{
	// Attributes
	private int width, height;
	private Point position;
	// Constructor
	public Rectangle() {
		this.position = new Point(0,0);
		this.width = 1;
		this.height = 1;
		this.setColor(Color.black);
		this.setName("Rectangle");
	};
	public Rectangle(Point position, int width, int height) {
		this.position = position;
		this.width = width;
		this.height = height;
		this.setColor(Color.black);
		this.setName("Rectangle");
	}
	// Methods
	// setters
	public void setLocation(int x1, int y1) {
		position.x = x1;
		position.y = y1;
	}
	public void setDimension(int width, int height) {
		this.width = width;
		this.height = height;
	}
	// getters
	public Point getLocation() {
		return position;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	@Override
	public void draw(Graphics g) {
		g.setColor(this.getColor());
		g.drawRect(position.x, position.y, width, height);
	};
	// containing function
	@Override
	public boolean contains (int x, int y) {
		return ((x >= position.x && x <= position.x + width) && (y >= position.y && x <= position.y + height));
	};
}
