import processing.core.PApplet;

public class Cockpit 
{
	private Dial dial;
	private double altitude;
	
	/**
	 * Constructor to initialize Cockpit object with speed dial
	 * @param d
	 */
	public Cockpit(Dial d) {
		dial = d;
	}
	
	/**
	 * Draws Cockpit object with PApplet
	 * @param p PApplet used to draw Cockpit object
	 */
	public void draw(PApplet p) {
		dial.draw(p);
		p.fill(255);
		p.rect(25, 250, 150, 50);
		p.fill(0);
		p.textSize(26);
		p.text(altitude+"", 80, 283);
	}
	
	/**
	 * Increments or decrements altitude of plane
	 * @param a Value to change altitude by
	 */
	public void changeAltitude(double a) {
		altitude+=a;
	}
	
	/**
	 * Returns altitude of plane
	 * @return Altitude of plane
	 */
	public double getAltitude() {
		return altitude;
	}
}
