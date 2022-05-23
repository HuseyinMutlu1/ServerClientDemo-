package Shape;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

public interface Shape {
	
	public void SetCoordinate(Point p);
	public String getShapeInfo();
	public Point getRandomPoint();
	public String GetType();
	public void update();
	public void paint(Graphics g) ;

}
