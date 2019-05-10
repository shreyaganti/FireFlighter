import processing.core.PApplet;
import processing.core.PImage;

public class Runway 
{
	private String airport;
	private PImage runwayImage;
	private double x,y;
	
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
		runwayImage.resize(120, 60);
	}
	
	public void draw(PApplet drawer)
	{
		drawer.image(runwayImage,(float)x, (float)y);
	}
}
