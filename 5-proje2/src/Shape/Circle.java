package Shape;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Circle  implements Shape{
	public String type="CIRCLE";
	public int ratio;
	public Point randomPoint=new Point(300,50);
	public Point origin=new Point();
	public int speed=1;
	
	public Circle() {
		// TODO Auto-generated constructor stub
	}
	public Circle(Point org, int ratio) {
		
	this.ratio=ratio;
	this.origin=org;

	}

	@Override
	public String getShapeInfo() {
		
		//System.out.println("CIRCLE ORIGIN :("+ this.origin.x +","+this.origin.y+")");
		//System.out.println("CIRCLE RATIO : "+this.ratio);
		return "CIRCLE position :("+ this.origin.x +","+this.origin.y+")";
	}
	@Override
	public void SetCoordinate(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
		public String GetType() {
			return type;
		}
	
		@Override
		public void update() {
			
			//System.out.println("random" + randomPoint.x);
		
			if(this.origin.x < randomPoint.x) {
				this.origin.x=this.origin.x+1;
			}
			if(this.origin.x > randomPoint.x) {
				this.origin.x=this.origin.x-1;
			}
			if(this.origin.x == randomPoint.x) {
				randomPoint=getRandomPoint();
				
				
				}
			}
			
			//this.origin.x=this.origin.x+speed;
			//this.origin.y=this.origin.y+speed;
		
		@Override
		  public void paint(Graphics g) {
				
			  g.setColor(Color.blue);
			  g.fillOval(origin.x,origin.y , ratio, ratio);
				  
			  

		  }
		@Override
		public Point getRandomPoint() {
			double randNumberx = Math.random();
			double dsx = randNumberx * 890;
	        int randomIntx = (int)dsx;
			randomPoint.x=randomIntx;
			double randNumbery = Math.random();
			double dsy = randNumbery * 890;
	        int randomInty = (int)dsy;
			randomPoint.y=randomInty;
			
			return randomPoint;
		}
		
}
