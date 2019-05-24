import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class represents an animated lightning with (x,y) coordinate
 * 
 * @author Ashwini Suriyaprakash, Shreya Ganti
 * @version 5/22/19
 */
public class Lightning 
{
	private PImage[] lightningImages;
	private final int GIF_COUNT = 4;
	private int lightningFrame;
	private double x,y;

	/**
	 * Creates a Lightning object
	 * @param x x coordinate of the lightning's center
	 * @param y y coordinate of the lightning's center
	 */
	public Lightning(double x, double y)
	{
		this.x = x;
		this.y = y;
		this.lightningImages = new PImage[GIF_COUNT];
		this.lightningFrame = 0;
	}

	/**
	 * Loads lightning images
	 * @param drawer PApplet needed for the setup
	 */
	public void setup(PApplet drawer)
	{
		for (int i = 0; i < GIF_COUNT; i++) 
		{
			lightningImages[i] = drawer.loadImage("images/lightning" + (i+1) + ".gif");
			lightningImages[i].resize(200, 300);
		}
	}

	/**
	 * Shifts the Lightning's location
	 * @param offsetX amount in the x direction the lightning should be shifted by
	 * @param offsetY amount in the y direction the lightning should be shifted by
	 */
	public void shift(double offsetX, double offsetY)
	{
		x+=offsetX;
		y+=offsetY;
	}

	/**
	 * Draws the Lightning object on a PApplet
	 * @param drawer PApplet on which Lightning object is drawn
	 */
	public void draw(PApplet drawer)
	{
		lightningFrame = (lightningFrame+1) % GIF_COUNT;
		drawer.image(lightningImages[lightningFrame], (float)(x-getWidth()/2), (float)(y-getHeight()/2));
	}

	/**
	 * @return width of the lightning
	 */
	public double getWidth() 
	{
		return lightningImages[0].width;
	}

	/**
	 * @return height of the lightning
	 */
	public double getHeight() 
	{
		return lightningImages[0].height;
	}


	/**
	 * @return x coordinate of the lightning
	 */
	public double getX() 
	{
		return x;
	}

	/**
	 * @return y coordinate of the lightning
	 */
	public double getY() 
	{
		return y;
	}
}
