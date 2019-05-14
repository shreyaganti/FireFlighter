import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class represents an Image with (x,y) coordinate
 * @author Ashwini Suriyaprakash
 * @version 5/13/19
 */
public class Image 
{
	private double x,y;
	private PImage image;
	private String imageFilePath;
	
	/**
	 * Creates an instance of an Image
	 * @param x x coordinate of the image
	 * @param y y coordinate of the image
	 * @param filename the filename the image is stored in
	 */
	public Image(double x, double y, String filename)
	{
		this.x = x;
		this.y = y;
		this.image = null;
		this.imageFilePath = filename;
	}
	
	/**
	 * Draws the Image on a PApplet
	 * @param drawer the PApplet the Image is drawn on
	 * @param width width the image should be
	 * @param height height the image should be
	 */
	public void draw(PApplet drawer, int width, int height)
	{
		image = drawer.loadImage(imageFilePath);
		if (image != null)
		{
			image.resize(width, height);
			drawer.image(image,(float)x,(float)y);
		}
	}
	
	/**
	 * Shifts the image by some amount in the x and y directions
	 * @param offsetX the x amount to shift the image by
	 * @param offsetY the y amount to shift the image by
	 */
	public void shift(double offsetX, double offsetY)
	{
		x+=offsetX;
		y+=offsetY;
	}
	
	/**
	 * @return x coordinate of the image
	 */
	public double getX()
	{
		return x;
	}
	
	/**
	 * @return y coordinate of the image
	 */
	public double getY()
	{
		return y;
	}
}
