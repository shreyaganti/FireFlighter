import processing.core.PApplet;

public class Background 
{
	private Image[] backgroundImages;
	private final int NUM_IMAGES = 10;
	
	public Background()
	{
		this.backgroundImages = new Image[NUM_IMAGES];
		for (int x = 0; x < NUM_IMAGES; x++)
		{
			if (x%2 == 0)
			{
				backgroundImages[x] = new Image(300+700*x, 0, "images/scenery.jpg");
			}
			else
			{
				backgroundImages[x] = new Image(300+700*x, 0, "images/scenery-flipped.jpg");
			}
		}
		
	}
	
	// Scrolls the sky to make the plane look like it is moving
	public void scrollSkySideways(double v)
	{
		for (int x = 0; x < NUM_IMAGES; x++)
		{
			backgroundImages[x].shift(-v, 0);
		}
	}
	
	public void draw(PApplet drawer)
	{
		for (int x = 0; x < NUM_IMAGES; x++)
		{
			if (backgroundImages[x] != null)
			{
				backgroundImages[x].draw(drawer,700,500);
			}
		}
		// drawer.background(0,0,255);
	}
}
