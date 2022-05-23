package Shape;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Triangle  implements Shape{
	public String type="TRIANGLE";
	public Point p1=new Point();
	public Point p2=new Point();
	public Point p3=new Point();
	public Point randomPoint= new Point();
	
	public int speed=1;
	public Triangle() {
	
	}
	
	public Triangle(Point p1,Point p2,Point p3) {
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
	
	}

	@Override
	public String getShapeInfo() {
		//System.out.println("POINT 1: ("+this.p1.x+","+this.p1.y+")");
		//System.out.println("POINT 2: ("+this.p2.x+","+this.p2.y+")");
		//System.out.println("POINT 3: ("+this.p3.x+","+this.p3.y+")");
		
		return "Triangle position : ("+this.p1.x+","+this.p1.y+")";
		
	}

	@Override
	public void SetCoordinate(Point p) {
		
		
	}

	
	@Override
	public String GetType() {
		return type;
	}
	@Override
	public void update() {
		if(p1.y < randomPoint.y) {
			p1.y=p1.y+speed;	
			p2.y=p2.y+speed;
			p3.y=p3.y+speed;
		}
		if(p1.y > randomPoint.y) {
			p1.y=p1.y-speed;	
			p2.y=p2.y-speed;
			p3.y=p3.y-speed;
		}
		if(p1.x < randomPoint.x) {
			p1.x=p1.x+speed;	
			p2.x=p2.x+speed;
			p3.x=p3.x+speed;
		}
		if(p1.x > randomPoint.x) {
			p1.x=p1.x-speed;	
			p2.x=p2.x-speed;
			p3.x=p3.x-speed;
		}
		if(p1.y  == randomPoint.y &&p1.x == randomPoint.x) {
			randomPoint=getRandomPoint();
		}
		
		/*p1.x=p1.x+speed;
		p2.x=p2.x+speed;
		p3.x=p3.x+speed;
		p1.y=p1.y+speed;
		p2.y=p2.y+speed;
		p3.y=p3.y+speed;
	*/
	  }
	@Override
	  public void paint(Graphics g) {
		
				    int x[] = {p1.x,p2.x,p3.x};
				    int y[] = {p1.y,p2.y,p3.y};
				    //int npoints = x.length;//or y.length

				    g.drawPolygon(x, y, 3);//draws polygon outline
				    g.fillPolygon(x, y, 3);//paints a polygon
				    

	  }

	@Override
	public Point getRandomPoint() {
		double randNumberx = Math.random();
		double dsx = randNumberx * 500;
        int randomIntx = (int)dsx;
		randomPoint.x=randomIntx;
		double randNumbery = Math.random();
		double dsy = randNumbery * 500;
        int randomInty = (int)dsy;
		randomPoint.y=randomInty;
		
		return randomPoint;
	}
	  

				
		
}
