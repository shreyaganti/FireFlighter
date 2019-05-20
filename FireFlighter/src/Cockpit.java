import processing.core.PApplet;

/**
 * This class represents the cockpit of an airplane with altitude measurement and dial for speed
 * @author Shreya Ganti, Ashwini Suriyaprakash
 * @version 5/22/19
 */
public class Cockpit 
{
	private Dial dial;
	private int altitude;
	private LocationTracker locTrack;
	
	/**
	 * Constructor to initialize Cockpit object with speed dial and location tracker
	 * @param d Dial object for speed
	 * @param loc LocationTracker object
	 */
	public Cockpit(Dial d, LocationTracker loc) 
	{
		dial = d;
		altitude = 0;
		locTrack = loc;
	}
	
	/**
	 * Sets up the Cockpit
	 * @param drawer PApplet need to setup the cockpit
	 */
	public void setup(PApplet drawer)
	{
		dial.setup(drawer);
		locTrack.setup(drawer);
	}
	
	/**
	 * Draws Cockpit object with PApplet
	 * @param p PApplet used to draw Cockpit object
	 */
	public void draw(PApplet p) 
	{
		// System.out.println("Drawing cockpit");
		p.pushMatrix();
		p.pushStyle();
		p.fill(0,0,128);
		p.rect(0, 0, 300, 500);
		dial.draw(p);
		p.fill(255);
		p.rect(60, 225, 180, 50);
		p.fill(0);
		p.textSize(26);
		p.text(altitude+" ft", 125, 260);
		locTrack.draw(p);
		p.popStyle();
		p.popMatrix();
	}
	
	/**
	 * Sets value of altitude of plane
	 * @param a New value to assign to altitude
	 */
	public void setAltitude(int a) 
	{
		altitude = a;
	}
	
	/**
	 * @return Altitude of plane
	 */
	public int getAltitude() 
	{
		return altitude;
	}
	
	/**
	 * @return Dial object located in cockpit
	 */
	public Dial getDial() 
	{
		return dial;
	}
	
	/**
	 * @return LocationTracker object in the Cockpit
	 */
	public LocationTracker getLocTrack() 
	{
		return locTrack;
	}
}
