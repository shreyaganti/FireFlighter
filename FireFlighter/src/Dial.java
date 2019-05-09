import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

/**
 * This class represents a dial that keeps track of a measurement
 * 
 * @author Shreya Ganti
 * @version 5/7/19
 */
public class Dial 
{
	private double speed;
	private double xCoord,yCoord; //center of dial
	private PImage dial;
	private boolean maxSpeed = false;
	private boolean minSpeed = true;
	
	/**
	 * Constructor to initialize Dial object with x,y coordinates representing center
	 * @param x x-coordinate of center of Dial
	 * @param y y-coordinate of center of Dial
	 */
	public Dial(double x, double y) {
		speed = 850; //starting at 850 refers to speed of 50 mph
		xCoord = x;
		yCoord = y;
	}
	
	/**
	 * Loads dial image
	 * @param drawer PApplet required for the setup
	 */
	public void setup(PApplet drawer)
	{
		dial = drawer.loadImage("images/speed_dial.png");
	}
	/**
	 * Draws the dial object
	 * @param p PApplet object used to draw the dial
	 */
	public void draw(PApplet p) 
	{
		p.pushMatrix();
		p.pushStyle();
		
		dial.resize(200, 200);
		if (speed == 360) {
			speed = 0;
		}
		p.imageMode(p.CENTER);
		p.image(dial,(float)xCoord,(float)yCoord);
		p.strokeWeight(10);
		if (Math.abs(1130-speed) <=0.001) {
			maxSpeed = true;
		}
		else {
			maxSpeed = false;
		}
		if (Math.abs(850-speed)<=0.001) {
			minSpeed = true;
		}
		else {
			minSpeed = false;
		}
		System.out.println(speed + "    " + minSpeed+"   "+ maxSpeed);
		p.line((float)xCoord,(float)yCoord,(float)(Math.cos(Math.toRadians(speed))*(dial.width/2-10)+xCoord),(float)((Math.sin(Math.toRadians(speed))*(dial.height/2-10)+yCoord)));
		p.popStyle();
		p.popMatrix();
	}
	
	/**
	 * Sets the speed value of the dial
	 * @param s New value of speed on dial
	 */
	public void setSpeed(double s) {
		speed = s;
	}
	
	/**
	 * Increments speed on dial
	 * @param s Value to increment speed on dial
	 */
	public void addSpeed(double s) {
		speed+=s;
		// System.out.println(speed);
		// System.out.println(Math.cos(Math.toRadians(speed)) + "  " + Math.sin(Math.toRadians(speed)));
	}
	
	/**
	 * Returns if speed dial has reached its max speed
	 * @return true if max speed is reached, false otherwise
	 */
	public boolean reachedMax() {
		return maxSpeed;
	}
	
	/**
	 * Returns if speed dial has reached its minimum speed
	 * @return true if minimum speed is reached, false otherwise
	 */
	public boolean reachedMin() {
		return minSpeed;
	}
	
	
}
