import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

/**
 * This class represents a dial that keeps track of a measurement, specifically speed
 * 
 * @author Shreya Ganti, Ashwini Suriyaprakash
 * @version 5/22/19
 */
public class Dial 
{
	private double speed;
	private double xCoord,yCoord; //center of dial
	private PImage dial;
	private int maxVal;
	
	/**
	 * Constructor to initialize Dial object with x,y coordinates representing center
	 * @param x x-coordinate of center of Dial
	 * @param y y-coordinate of center of Dial
	 * @param maxVal maximum value the dial can show
	 * @pre maxVal has to be positive
	 */
	public Dial(double x, double y, int maxVal) 
	{
		speed = 0;
		xCoord = x;
		yCoord = y;
		this.maxVal = maxVal;
	}
	
	/**
	 * Loads dial image
	 * @param drawer PApplet required for the setup
	 */
	public void setup(PApplet drawer)
	{
		dial = drawer.loadImage("images/speed_dial.png");
		dial.resize(200, 200);
	}
	
	public void draw(PApplet drawer)
	{
		drawer.pushMatrix();
		drawer.pushStyle();
		drawer.imageMode(drawer.CENTER);
		drawer.image(dial,(float)xCoord,(float)yCoord);
		drawer.fill(255);
		double angle = 222;
		int measure = 0;
		double width = dial.width/3;
		for (int i = 0; i < 10; i++)
		{
			if (angle == 110)
			{
				width = dial.width/3.4;
			}
			
			if (angle < 110)
			{
				width = dial.width/3.7;
				angle-=5;
			}
			
			if (angle <= 54)
			{
				width = dial.width/4.0;
			}
			
			Line l = Line.getLineFromAngle(xCoord, yCoord,angle,width);
			drawer.text(measure+"", (float)l.getX2(), (float)l.getY2());
			angle-=28;
			measure+=maxVal/9;
		}
		
		double interval = maxVal/9;
		drawer.fill(0);
		drawer.strokeWeight(10);
		int diff = (int)(speed/interval);
		int rem = (int)(speed%interval);
		double rodAngle = diff*28 + (28*rem)/interval;
		// System.out.println("Diff: " + diff);
		// System.out.println("Rem: " + rem);
		// System.out.println("Speed: " + speed);
		// System.out.println("Angle: " + rodAngle);
		
		rodAngle=222-rodAngle;
		// System.out.println("Angle: " + rodAngle);
		
		Line l = Line.getLineFromAngle(xCoord,yCoord,rodAngle,dial.width/2-10);
		drawer.line((float)xCoord,(float)yCoord,(float)l.getX2(),(float)l.getY2());
		drawer.popStyle();
		drawer.popMatrix();
	}
	
	/**
	 * Sets the speed value of the dial
	 * @param s New value of speed on dial
	 */
	public void setSpeed(double s) 
	{
		speed = s;
	}
}
