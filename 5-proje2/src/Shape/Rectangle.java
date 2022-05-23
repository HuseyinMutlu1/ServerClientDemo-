package Shape;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Rectangle  implements Shape{
	public String type="RECT";
	public int width;
	public int height;
	public Point br=new Point();
	public Point tl=new Point();
	public Point randomPoint=new Point(150,250);
	
	public int speed=1;
	
	public Rectangle() {

	}		
	public Rectangle(Point tl,int width,int height) {
		
		this.tl=tl;
		this.width=width;
		this.height=height;
		this.br.x=Math.abs(tl.x+width);
		this.br.y=Math.abs(tl.y+height);

		
		
	}
	public Rectangle(Point tl,Point br) {
		this.br=br;
		this.tl=tl;
		this.width=Math.abs(br.x-tl.x);
		this.height=Math.abs(tl.y-br.y);

	}

	@Override
	public String getShapeInfo() {
		//System.out.println("TOP LEFT: ("+tl.x+","+tl.y+")");
		//System.out.println("BOTTOM RIGHT: ("+br.x+","+br.y+")");
		//System.out.println("Rect width: "+width);
		//System.out.println("Rect height: "+height);
		return "Rect TOP LEFT Position: ("+tl.x+","+tl.y+")";
	}
	@Override
	public void SetCoordinate(Point p) {
		
		
	}

	public String GetType() {
		return type;
	}
	@Override
	public void update() {
		if(this.tl.y < randomPoint.y) {
			this.tl.y=this.tl.y+speed;	
		}
		if(this.tl.y > randomPoint.y) {
			this.tl.y=this.tl.y-speed;
		}
		if(this.tl.x < randomPoint.x) {
			this.tl.x=this.tl.x+speed;	
		}
		if(this.tl.x > randomPoint.x) {
			this.tl.x=this.tl.x-speed;
		}
		if(this.tl.y == randomPoint.y &&this.tl.x == randomPoint.x) {
			randomPoint=getRandomPoint();
			//System.out.println(this.tl.y);
			
			}
	//	this.tl.y=tl.y+speed;
		//this.tl.x=tl.x+speed;

	
	}
	@Override
	  public void paint(Graphics g) {
			
			 
			  g.setColor(Color.red);
			  g.fillRect(tl.x,tl.y,width,height);
				
	  }
	@Override
	public Point getRandomPoint() {
		double randNumberx = Math.random();
		double dsx = randNumberx * 900;
        int randomIntx = (int)dsx;
		randomPoint.x=randomIntx;
		double randNumbery = Math.random();
		double dsy = randNumbery * 900;
        int randomInty = (int)dsy;
		randomPoint.y=randomInty;
		
		return randomPoint;
	}


		
}
