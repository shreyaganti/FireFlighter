import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class Dial {

	private double speed;
	private double xCoord,yCoord; //top left corner of dial
	private PImage arrow; //draw papplet line instead of image
	private PImage dial;
	
	public Dial(double x, double y) {
		speed = 0;
		xCoord = x;
		yCoord = y;
	}
	
	public void setup() {
		//arrow = loadImage("images//arrow.png");
		//arrow.resize(200, 200);
	}
	/**
	 * Draws the dial object
	 * @param p PApplet object used to draw the dial
	 */
	public void draw(PApplet p) {
		dial = p.loadImage("images//speed_dial.png");
		dial.resize(200, 200);
		p.imageMode(p.CENTER);
		p.image(dial,(float)xCoord,(float)yCoord);
		p.pushMatrix();
		p.strokeWeight(10);
		p.line(dial.width/2,dial.height/2,(float)Math.cos(speed),(float)Math.sin(speed));
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
	}
}
