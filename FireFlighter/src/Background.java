import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Represents a background for the plane, containing scenery images and fires
 * @author Ashwini Suriyaprakash
 * @version 5/8/19
 */
public class Background 
{
	private Image[] backgroundImages;
	private ArrayList<Fire> fires;
	private final int NUM_IMAGES = 10;
	private final int NUM_FIRES = 10;
	
	/**
	 * Creates an instance of a Background with scenery images and fires at random locations initialized
	 */
	public Background()
	{
		this.backgroundImages = new Image[NUM_IMAGES];
		this.fires = new ArrayList<Fire>();
		
		for (int f = 0; f < NUM_FIRES; f++)
		{
			double xcoord = 300+Math.random()*NUM_IMAGES*700;
			double ycoord = 370;
			fires.add(new Fire(xcoord,ycoord));
		}
		
	}
	
	/**
	 * Loads scenery images and sets up the background's fires
	 * @param drawer PApplet required for the setup
	 */
	public void setup(PApplet drawer)
	{
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
		
		for (int f = 0; f < NUM_FIRES; f++)
		{
			fires.get(f).setup(drawer);
		}
	}
	
	/**
	 * Scrolls the background to the left to make it look like the plane is moving
	 * @param v the velocity of scrolling
	 */
	public void scrollBackgroundSideways(double v)
	{
		for (int x = 0; x < NUM_IMAGES; x++)
		{
			backgroundImages[x].shift(v, 0);
			fires.get(x).shift(v,0);
		}
	}
	
	/**
	 * Draws a Background object on a PApplet
	 * @param drawer PApplet on which the Background object is drawn
	 */
	public void draw(PApplet drawer)
	{
		for (int x = 0; x < NUM_IMAGES; x++)
		{
			if (backgroundImages[x] != null)
			{
				backgroundImages[x].draw(drawer,700,500);
			}
		}
		
		for (int f = 0; f < NUM_FIRES; f++)
		{
			fires.get(f).draw(drawer);
		}
		// drawer.background(0,0,255);
	}
	
	/**
	 * @return ArrayList of fires this Background object contains
	 */
	public ArrayList<Fire> getFires()
	{
		return fires;
	}
}
