import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class represents a runway with an (x,y) coordinate
 * 
 * @author Ashwini Suriyaprakash
 * @version 5/10/19
 */
public class Runway 
{
	private String airport;
	private PImage runwayImage;
	private double x,y;
	
	/**
	 * Creates a Runway object
	 * @param x x coordinate of runway
	 * @param y y coordinate of runway
	 * @param airport the airport the runway represents
	 */
	public Runway(double x, double y, String airport)
	{
		this.x = x;
		this.y = y;
		this.airport = airport;
	}
	
	/**
	 * Loads the runway image from file
	 * @param drawer PApplet required for the setup
	 */
	public void setup(PApplet drawer) 
	{
		runwayImage = drawer.loadImage("images/runway.png");
		runwayImage.resize(700, 80);
	}
	
	/**
	 * Shifts the runway by x and y amount
	 * @param offsetX x amount to shift the runway by
	 * @param offsetY y amount to shift the runway by
	 */
	public void shift(double offsetX, double offsetY)
	{
		x+=offsetX;
		y+=offsetY;
	}
	
	/**
	 * Draws the runway
	 * @param drawer Papplet to draw the runway on
	 */
	public void draw(PApplet drawer)
	{
		drawer.image(runwayImage,(float)x, (float)y);
	}
	
	
}
