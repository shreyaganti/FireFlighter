import processing.core.PApplet;
import processing.core.PImage;

public class Fire 
{
	private PImage[] images;
	private final int IMAGE_COUNT = 2;
	private int frame;
	private double x,y;
	private boolean isExtinguished;
	
	// Fire
	public Fire(double x, double y)
	{
		this.x = x;
		this.y = y;
		this.images = new PImage[IMAGE_COUNT];
		this.frame = 0;
		this.isExtinguished = false;
	}
	
	public void setup(PApplet drawer)
	{
		for (int i = 0; i < IMAGE_COUNT; i++) 
		{
			// images[i] = drawer.loadImage("images//fire.gif");
			images[i] = drawer.loadImage("images//fire" + (i+1) + ".gif");
		}
	}
	
	public void shift(double offsetX, double offsetY)
	{
		x+=offsetX;
		y+=offsetY;
	}
	
	public void draw(PApplet drawer)
	{
		frame = (frame+1) % IMAGE_COUNT;
		if (!isExtinguished)
			drawer.image(images[frame], (float)x, (float)y);
		
		// drawer.fill(255,0,0);
		// drawer.rect((float)x, (float)y, 10, 10);
	}
	
	public void extinguish() 
	{
		isExtinguished = true;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getWidth() {
		return images[0].width;
	}
}
