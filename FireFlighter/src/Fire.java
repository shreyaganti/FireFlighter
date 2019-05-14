import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class represents an animated fire with (x,y) coordinate and can either be extinguished/not extinguished
 * 
 * @author Ashwini Suriyaprakash
 * @version 5/8/19
 */
public class Fire 
{
	private PImage[] flameImages;
	private PImage[] smokeImages;
	private final int IMAGE_COUNT = 2;
	private int frame;
	private double x,y;
	private boolean isExtinguished;
	
	/**
	 * Creates a Fire object that is not extinguished
	 * @param x x coordinate of the fire
	 * @param y y coordinate of the fire
	 */
	public Fire(double x, double y)
	{
		this.x = x;
		this.y = y;
		this.flameImages = new PImage[IMAGE_COUNT];
		this.smokeImages = new PImage[IMAGE_COUNT];
		this.frame = 0;
		this.isExtinguished = false;
	}
	
	/**
	 * Loads flame and smoke images
	 * @param drawer PApplet needed for the setup
	 */
	public void setup(PApplet drawer)
	{
		for (int i = 0; i < IMAGE_COUNT; i++) 
		{
			// images[i] = drawer.loadImage("images//fire.gif");
			flameImages[i] = drawer.loadImage("images/fire" + (i+1) + ".gif");
			flameImages[i].resize(100, 100);
		}
		
		for (int i = 0; i < IMAGE_COUNT; i++) 
		{
			// images[i] = drawer.loadImage("images//fire.gif");
			smokeImages[i] = drawer.loadImage("images/smoke" + (i+1) + ".gif");
			smokeImages[i].resize(100, 100);
		}
	}
	
	/**
	 * Shifts the Fire's location
	 * @param offsetX amount in the x direction the fire should be shifted by
	 * @param offsetY amount in the y direction the fire should be shifted by
	 */
	public void shift(double offsetX, double offsetY)
	{
		x+=offsetX;
		y+=offsetY;
	}
	
	/**
	 * Draws the Fire object on a PApplet
	 * @param drawer PApplet on which Fire object is drawn
	 */
	public void draw(PApplet drawer)
	{
		frame = (frame+1) % IMAGE_COUNT;
		if (!isExtinguished)
			drawer.image(flameImages[frame], (float)(x-getWidth()/2), (float)(y-getHeight()/2));
		else
		{
			drawer.image(smokeImages[frame], (float)(x-getWidth()/2), (float)(y-getHeight()/2));
		}
	}
	
	/**
	 * Extinguishes the fire
	 */
	public void extinguish() 
	{
		isExtinguished = true;
	}
	
	/**
	 * Checks for collision between Fire and a WaterSpray object
	 * @param spray WaterSpray object to check for collision with
	 * @return true if this Fire was hit by WaterSpray, otherwise false
	 */
	public boolean isHitByWaterSpray(WaterSpray spray)
	{
		if (spray.getX() >= x && spray.getX() <= x+getWidth() && spray.getY()+spray.getHeight()>=y) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @return x coordinate of the fire
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * @return y coordinate of the fire
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * @return width of the fire
	 */
	public double getWidth() 
	{
		return flameImages[0].width;
	}
	
	/**
	 * @return height of the fire
	 */
	public double getHeight() 
	{
		return flameImages[0].height;
	}
	
	public boolean isExtinguished() 
	{
		return isExtinguished;
	}
}
