import processing.core.PApplet;
import processing.core.PImage;

public class Fire 
{
	private PImage[] images;
	private final int IMAGE_COUNT = 2;
	private int frame;
	private double x,y;
	
	// Fire
	public Fire(double x, double y)
	{
		this.x = x;
		this.y = y;
		this.images = new PImage[IMAGE_COUNT];
		this.frame = 0;
		
	}
	
	public void draw(PApplet drawer)
	{
		for (int i = 0; i < IMAGE_COUNT; i++) 
		{
			images[i] = drawer.loadImage("images//fire.gif");
			images[i] = drawer.loadImage("images//fire" + (i+1) + ".gif");
		}
		
		frame = (frame+1) % IMAGE_COUNT;
		System.out.println("Frame:" + frame);
		drawer.image(images[frame], (float)x, (float)y);
		
		// drawer.fill(255,0,0);
		// drawer.rect((float)x, (float)y, 10, 10);
	}
}
