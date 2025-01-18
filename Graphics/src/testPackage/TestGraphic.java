package testPackage;
import modelsPackage.*;
import java.awt.*;
//For event We need to import event package from java.awt
import java.awt.event.*;
// For using List we need to import List package from java.utils
import java.util.*;
import java.util.List;
// For avoiding similarity problem we need to import specially the Rectangle class that we made
import modelsPackage.Rectangle;

public class TestGraphic extends Frame{
	
	private static final long serialVersionUID = 1L;
	//Value to get 
	String figureShape = null;
	Color figureColor = Color.black;
	int figureSize = 20;
	
	//Class for dialog creation
	class mydialog extends Dialog{
		private static final long serialVersionUID = 1L;
		//inputs
		Choice possibleColor;
		TextField sizepart;
		mydialog(Frame o){
			super(o,"Créer une Figure",true);
			setSize(300,200);
			setLayout(new FlowLayout());
			
			//Color input and possible choice
			Label labelC = new Label("Entrez la couleur :");
			possibleColor = new Choice();
			possibleColor.addItem("black");
			possibleColor.addItem("blue");
			possibleColor.addItem("cyan");
			possibleColor.addItem("red");
			possibleColor.addItem("green");
			possibleColor.addItem("magenta");
			possibleColor.addItem("orange");
			possibleColor.addItem("yellow");
			
			add(labelC);
			add(possibleColor);
			
			//Size input
			
			Label sizepartField = new Label("Entrez la taille :");
			sizepart = new TextField("20",5);
			add(sizepartField);
			add(sizepart);
			
			//Buttons creation
			
			Button rectangleB = new Button("Rectangle");
			Button lineB = new Button("Line");
			Button circleB = new Button("Circle");
			
			rectangleB.addActionListener(e->{
				figureShape = "Rectangle";
				chooseParameters();
				setVisible(false);
			});
			lineB.addActionListener(e->{
				figureShape = "Line";
				chooseParameters();
				setVisible(false);
			});
			circleB.addActionListener(e->{
				figureShape = "Circle";
				chooseParameters();
				setVisible(false);
			});
			
			add(rectangleB);
			add(lineB);
			add(circleB);
			
			addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e) {
					setVisible(false);
				}
			});
		}
		
		public void chooseParameters() {
			//setting the color chosen 
			String colorstr = possibleColor.getSelectedItem();
			switch(colorstr) {
			case "black" : figureColor = Color.black;
				break;
			case "blue" : figureColor = Color.blue;
				break;
			case "cyan" : figureColor = Color.cyan;
				break;
			case "red" : figureColor = Color.red;
				break;
			case "green" : figureColor = Color.green;
				break;
			case "magenta" : figureColor = Color.magenta;
				break;
			case "orange" : figureColor = Color.orange;
				break;
			case "yellow" : figureColor = Color.yellow;
				break;
			}
			
			//setting the size put
			try {
				figureSize = Integer.parseInt(sizepart.getText());
			}catch(NumberFormatException ex){
				figureSize = 20; // set a default value
			}
		}
			
	}
	//DrawComponent creation 
	
	class DrawComponent extends Canvas implements MouseListener,MouseMotionListener{
		private static final long serialVersionUID = 1L;
		List<Rectangle> allRectangles;
		List<Line> allLines;
		List<Circle> allCircles;
		int offsetX, offsetY;
		Rectangle selectedFigureR = null;
		Line selectedFigureL = null;
		Circle selectedFigureC = null;
		public DrawComponent(){
			this.allRectangles = new ArrayList<>();
			this.allLines = new ArrayList<>();
			this.allCircles = new ArrayList<>();
			addMouseListener(this);
			addMouseMotionListener(this);
		}
		
		//paint function
		public void paint(Graphics g) {
			//
			for(Figure figure : allRectangles) {
				figure.draw(g);
			}
			for(Figure figure : allLines) {
				figure.draw(g);
			}
			for(Figure figure : allCircles) {
				figure.draw(g);
			}
		}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if(figureShape != null) {
			Rectangle temporaryFigureR = null;
			Line temporaryFigureL = null;
			Circle temporaryFigureC = null;
			switch(figureShape) {
			case "Rectangle" : 
				temporaryFigureR = new Rectangle(new Point(x,y),figureSize + 10,figureSize);
				break;
			case "Circle" : 
				temporaryFigureC = new Circle(x,y,figureSize);
				break;
			case "Line" : 
				temporaryFigureL = new Line(x,y,x + figureSize, y + figureSize);
				break;
			}
			if(temporaryFigureR != null) {
				temporaryFigureR.setColor(figureColor);
				allRectangles.add(temporaryFigureR);
				repaint();				
			}
			if(temporaryFigureC != null) {
				temporaryFigureC.setColor(figureColor);
				allCircles.add(temporaryFigureC);
				repaint();				
			}
			if(temporaryFigureL != null) {
				temporaryFigureL.setColor(figureColor);
				allLines.add(temporaryFigureL);
				repaint();				
			}
			
			//We need to reset the figureShape value to null
			figureShape = null;
		}
	}
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
	        int y = e.getY();

	        // Find the figure that contains the clicked point
	        for (Line figure : allLines) {
	            if (figure.contains(x, y)) {
	                selectedFigureL = figure;
	                // Calculate the offset from where the mouse clicked to the figure's position
	                offsetX = x - figure.getExtremity1().x;
	                offsetY = y - figure.getExtremity1().y;
	                break;
	            }
	        }
	        for (Rectangle figure : allRectangles) {
	            if (figure.contains(x, y)) {
	                selectedFigureR = figure;
	                // Calculate the offset from where the mouse clicked to the figure's position
	                offsetX = x - figure.getLocation().x;
	                offsetY = y - figure.getLocation().y;
	                break;
	            }
	        }
	        for (Circle figure : allCircles) {
	            if (figure.contains(x, y)) {
	                selectedFigureC = figure;
	                // Calculate the offset from where the mouse clicked to the figure's position
	                offsetX = x - figure.getLocation().x;
	                offsetY = y - figure.getLocation().y;
	                break;
	            }
	        }
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			selectedFigureR = null; 
			selectedFigureL = null; 
			selectedFigureC = null; 
		}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (selectedFigureR != null) {
	            // Update the position of the selected figure
	            int x = e.getX() - offsetX;
	            int y = e.getY() - offsetY;
	            selectedFigureR.setLocation(x, y);
	            repaint(); // Redraw to reflect changes
	        }
			if (selectedFigureL != null) {
	            // Update the position of the selected figure
	            int x = e.getX() - offsetX;
	            int y = e.getY() - offsetY;
	            selectedFigureL.setExtremity1(x, y);
	            repaint(); // Redraw to reflect changes
	        }
			if (selectedFigureC != null) {
	            // Update the position of the selected figure
	            int x = e.getX() - offsetX;
	            int y = e.getY() - offsetY;
	            selectedFigureC.setLocation(x, y);
	            repaint(); // Redraw to reflect changes
	        }
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {

			
		}
		
	}
	// Frame constructor
	public TestGraphic() {
		setSize(500,500);
		DrawComponent drawC = new DrawComponent();
		add(drawC,BorderLayout.CENTER);
		
		Button creationButton = new Button("Créer une figure");
		creationButton.addActionListener(e->{
			mydialog dialog = new mydialog(this);
			dialog.setVisible(true);
		});
		
		add(creationButton,BorderLayout.NORTH);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}
	
	public static void main (String[] args) {
		new TestGraphic();
	}
}



/*
public class TestGraphic extends Frame{
	private static final long serialVersionUID = 1L;

	// DrawComponent
	class DrawComponent extends Canvas implements MouseListener{
		private static final long serialVersionUID = 1L;
		Circle c1;
		Circle c2;
		Circle c3;
		Rectangle r;
		
		public DrawComponent(Circle c1, Circle c2, Circle c3, Rectangle r) {
			this.c1 = c1;
			this.c2 = c2;
			this.c3 = c3;
			this.r = r;
				
			addMouseListener(this);
		}
		// function for drawing
		public void paint(Graphics g) {
			c1.draw(g);
			c2.draw(g);
			c3.draw(g);
			r.draw(g);
		}
		@Override
	    public void mouseClicked(MouseEvent e) {
	        int x = e.getX();
	        int y = e.getY();

	        if (c1.contains(x, y)) {
	        	//For the first circle
	            TestGraphic.changeColor(c1);
	            repaint();
	        }
	        if (c2.contains(x, y)) {
	        	//For the second circle
	            TestGraphic.changeColor(c2);
	            repaint();
	        }
	        if (c3.contains(x, y)) {
	        	//For the third circle
	            TestGraphic.changeColor(c3);
	            repaint();
	        }
	        if (r.contains(x, y)) {
	        	//For the rectangle
	            TestGraphic.changeColor(r);
	            repaint();
	        }
	    }
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}

	// Constructor
	public TestGraphic(Circle c1, Circle c2, Circle c3, Rectangle r) {
		setSize(500,500);
		DrawComponent draw = new DrawComponent(c1,c2,c3,r);
		add(draw);
		addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent windowEvent) {
	            System.exit(0);
	        }
	    });
		setVisible(true);
	}
	//Methods


	public static void changeColor(Figure f) {
		List<Color> colorCycle = Arrays.asList(
		        Color.BLACK, Color.BLUE, Color.CYAN, Color.RED, 
		        Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.YELLOW
		    );
		for (int i = 0; i< colorCycle.size(); i++) {
			if(f.getColor() == colorCycle.get(i)) {
				f.setColor(colorCycle.get((i+1)%colorCycle.size()));
				break;
			}
		}
	}

	public static void main (String[] args) {
		Circle c1 = new Circle(200,200,100);
		Circle c2 = new Circle(160,150,20);
		Circle c3 = new Circle(240,150,20);
		Rectangle r = new Rectangle(new Point(150,220),100,40);
		new TestGraphic(c1,c2,c3,r);
	}
}
*/
