import processing.core.PApplet;
import processing.core.PImage;

public class Image 
{
	private double x,y;
	private PImage image;
	private String imageFilePath;
	
	public Image(double x, double y, String filename)
	{
		this.x = x;
		this.y = y;
		this.image = null;
		this.imageFilePath = filename;
	}
	
	public void draw(PApplet drawer, int width, int height)
	{
		image = drawer.loadImage(imageFilePath);
		if (image != null)
		{
			image.resize(width, height);
			drawer.image(image,(float)x,(float)y);
		}
	}
	
	public void shift(double offsetX, double offsetY)
	{
		x+=offsetX;
		y+=offsetY;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
}
