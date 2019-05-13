import processing.core.PApplet;

public class LocationTracker {
	
	private String source, destination;
	private double x,y;
	
	/**
	 * Constructor to initialize location and source and destination labels of LocationTracker
	 * @param x x-coordinate of beginning of LocationTracker
	 * @param y y-coordinate of beginning of LocationTracker
	 * @param s name of source airport
	 * @param d name of destination airport
	 */
	public LocationTracker(int x, int y, String s, String d) {
		source = s;
		destination = d;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Draws the LocationTracker
	 * @param p PApplet object used to draw the LocationTracker
	 */
	public void draw(PApplet p) {
		p.line(75, (float)y, 225, (float)y);
		p.line(75, (float)(y+5), 75, (float)(y-5));
		p.line(225, (float)(y+5), 225, (float)(y-5));
		p.text(source, 75, (float)(y+7));
		p.text(destination, 225, (float)(y+7));
		//System.out.println(source+ "  :  " +destination);
		p.ellipseMode(p.RADIUS);
		p.ellipse((float)x, (float)y, 10, 10);
	}
	
	/**
	 * Increments the x value of LocationTracker
	 * @param a value to increment the x-coordinate by
	 */
	public void changeX(double a) {
		x+=a;
	}
	
	/**
	 * Sets the source airport
	 * @param s the new source airport
	 */
	public void setSource(String s) {
		source = s;
	}
	
	/**
	 * Sets the destination airport
	 * @param s the new destination airport
	 */
	public void setDestination(String d) {
		destination = d;
	}
}
