import processing.core.PApplet;

/**
 * 
 * @author Shreya Ganti
 * @version 5/7/19
 */
public class Cockpit 
{
	private Dial dial;
	private double altitude;
	
	/**
	 * Constructor to initialize Cockpit object with speed dial
	 * @param d
	 */
	public Cockpit(Dial d) 
	{
		dial = d;
	}
	
	public void setup(PApplet drawer)
	{
		dial.setup(drawer);
	}
	
	/**
	 * Draws Cockpit object with PApplet
	 * @param p PApplet used to draw Cockpit object
	 */
	public void draw(PApplet p) {
		p.pushMatrix();
		p.pushStyle();
		p.fill(0,0,128);
		p.rect(0, 0, 300, 500);
		dial.draw(p);
		p.fill(255);
		p.rect(25, 250, 150, 50);
		p.fill(0);
		p.textSize(26);
		p.text(altitude+"", 80, 283);
		p.popStyle();
		p.popMatrix();
	}
	
	/**
	 * Increments or decrements altitude of plane
	 * @param a Value to change altitude by
	 */
	public void changeAltitude(double a) {
		altitude+=a;
	}
	
	/**
	 * Sets value of altitude of plane
	 * @param a New value to assign to altitude
	 */
	public void setAltitude(double a) {
		altitude = a;
	}
	
	/**
	 * Returns altitude of plane
	 * @return Altitude of plane
	 */
	public double getAltitude() {
		return altitude;
	}
	
	/**
	 * Returns Dial object in the Cockpit
	 * @return Dial object located in cockpit
	 */
	public Dial getDial() {
		return dial;
	}
}
