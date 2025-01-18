package modelsPackage;
import java.awt.*;

public abstract class Figure {
	// Attributes
	private String Name;
	private Color color;
	// Constructor
	public Figure() {};
	// Methods
	// setters
	public void setColor(Color color) {
		this.color = color; 
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	// getters
	public String getName() {
		return this.Name;
	}
	public Color getColor() {
		return this.color;
	}
	// Drawing function 
	public abstract void draw(Graphics g);
	// containing function
	public abstract boolean contains (int x, int y);
}
