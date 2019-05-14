import processing.core.PApplet;

/**
 * This class represents the cockpit of an airplane with altitude measurement and dial for speed
 * @author Shreya Ganti
 * @version 5/7/19
 */
public class Cockpit 
{
	private Dial dial;
	private int altitude = 0;
	private LocationTracker locTrack;
	
	/**
	 * Constructor to initialize Cockpit object with speed dial
	 * @param d Dial object for speed
	 */
	public Cockpit(Dial d) 
	{
		dial = d;
		locTrack = new LocationTracker(0,300,"SFO","JFK");
	}
	
	public void setup(PApplet drawer)
	{
		dial.setup(drawer);
		locTrack.setup(drawer);
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
		p.rect(60, 250, 180, 50);
		p.fill(0);
		p.textSize(26);
		p.text(altitude*5+" ft", 125, 283);
		locTrack.draw(p);
		p.popStyle();
		p.popMatrix();
	}
	
	/**
	 * Increments or decrements altitude of plane
	 * @param a Value to change altitude by
	 */
	public void changeAltitude(int a) {
		altitude+=a;
	}
	
	/**
	 * Sets value of altitude of plane
	 * @param a New value to assign to altitude
	 */
	public void setAltitude(int a) {
		altitude = a;
	}
	
	/**
	 * Returns altitude of plane
	 * @return Altitude of plane
	 */
	public int getAltitude() {
		return altitude;
	}
	
	/**
	 * Returns Dial object in the Cockpit
	 * @return Dial object located in cockpit
	 */
	public Dial getDial() {
		return dial;
	}
	
	/**
	 * @return LocationTracker object in the Cockpit
	 */
	public LocationTracker getLocTrack() {
		return locTrack;
	}
}
