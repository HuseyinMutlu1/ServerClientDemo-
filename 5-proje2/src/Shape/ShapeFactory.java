package Shape;

public class ShapeFactory {

	public Shape getShape(String type) {
		if(type=="SQUARE") {
			return getSquare();
		}
		if(type=="RECT") {
			return getRectangle();
		}
		if(type=="CIRCLE") {
			return getCircle();
		} 
		if(type=="TRIANGLE") {
			return getTriangle();
		}
		else 
		{
			return new Rectangle();
		}
	}
		
		
		
	
	public Rectangle getSquare() {
		return new Rectangle(new Point(5,5),10,10);
	}
	public Rectangle getRectangle() {
		return new Rectangle(new Point(500,500),100,100);
	}
	public Circle getCircle() {
		return new Circle(new Point(300,300),100);
	}
	public Triangle getTriangle() {
		return new Triangle(new Point(70,200),new Point(110,70),new Point(170,200));
	}
	
}
