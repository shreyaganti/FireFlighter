import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class represents an animated fire with (x,y) coordinate and can either be extinguished/not extinguished
 * 
 * @author Ashwini Suriyaprakash
 * @version 5/22/19
 */
public class Fire 
{
	private PImage[] flameImages;
	private PImage[] smokeImages;
	private final int FIRE_GIF_COUNT = 5;
	private final int SMOKE_GIF_COUNT = 2;
	private int fireFrame, smokeFrame;
	private double x,y;
	private boolean isExtinguished;

	/**
	 * Creates a Fire object that is not extinguished
	 * @param x x coordinate of the fire's center
	 * @param y y coordinate of the fire's center
	 */
	public Fire(double x, double y)
	{
		this.x = x;
		this.y = y;
		this.flameImages = new PImage[FIRE_GIF_COUNT];
		this.smokeImages = new PImage[SMOKE_GIF_COUNT];
		this.fireFrame = 0;
		this.smokeFrame = 0;
		this.isExtinguished = false;
	}

	/**
	 * Loads flame and smoke images
	 * @param drawer PApplet needed for the setup
	 */
	public void setup(PApplet drawer)
	{
		for (int i = 0; i < FIRE_GIF_COUNT; i++) 
		{
			flameImages[i] = drawer.loadImage("images/fire" + (i+1) + ".gif");
			flameImages[i].resize(100, 100);
		}

		for (int i = 0; i < SMOKE_GIF_COUNT; i++) 
		{
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
		fireFrame = (fireFrame+1) % FIRE_GIF_COUNT;
		smokeFrame = (smokeFrame+1) % SMOKE_GIF_COUNT;
		if (!isExtinguished)
			drawer.image(flameImages[fireFrame], (float)(x-getWidth()/2), (float)(y-getHeight()/2));
		else
		{
			drawer.image(smokeImages[smokeFrame], (float)(x-getWidth()/2), (float)(y-getHeight()/2));
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
		if (spray.getX() >= x-getWidth()/2 && spray.getX() <= x+getWidth()/2 && spray.getY()+spray.getHeight()/2 >=y) 
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

	/**
	 * Returns whether fire is extinguished
	 * @return true if fire is extinguished, false otherwise
	 */
	public boolean isExtinguished() 
	{
		return isExtinguished;
	}
}
