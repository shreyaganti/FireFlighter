import java.util.ArrayList;

import processing.core.PApplet;

/**
 * Represents a background for the plane, containing scenery images and fires
 * @author Ashwini Suriyaprakash
 * @version 5/8/19
 */
public class Background 
{
	private ArrayList<Image> backgroundImages;
	private ArrayList<Fire> fires;
	private final int NUM_IMAGES = 10;
	private final int NUM_FIRES = 10;
	private Runway source, destination;
	private final int GROUND_LEVEL = 400;
	private boolean isEnd = false;
	
	/**
	 * Creates an instance of a Background with scenery images and fires at random locations initialized
	 */
	public Background()
	{
		this.backgroundImages = new ArrayList<Image>();// [NUM_IMAGES];
		this.fires = new ArrayList<Fire>();
		
		for (int f = 0; f < NUM_FIRES; f++)
		{
			double xcoord = 1000+Math.random()*(NUM_IMAGES-3)*700;
			double ycoord = 370;
			fires.add(new Fire(xcoord,ycoord));
		}
		source = new Runway(300,GROUND_LEVEL,"SFO");
		destination = new Runway(300+700*(NUM_IMAGES-2), GROUND_LEVEL, "NYC");
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
				backgroundImages.add(new Image(300+700*x, 0, "images/scenery.jpg"));
			}
			else
			{
				backgroundImages.add(new Image(300+700*x, 0, "images/scenery-flipped.jpg"));
			}
		}
		
		for (int f = 0; f < NUM_FIRES; f++)
		{
			fires.get(f).setup(drawer);
		}
		source.setup(drawer);
		destination.setup(drawer);
	}
	
	/**
	 * Scrolls the background to the left to make it look like the plane is moving until the last image
	 * @param v the velocity of scrolling
	 */
	public void scrollBackgroundSideways(double v)
	{
		// System.out.println(Math.abs(backgroundImages.get(NUM_IMAGES).getX()));
		if (backgroundImages.get(NUM_IMAGES-1).getX() <= 500)
		{
			// System.out.println(Math.abs(backgroundImages.get(NUM_IMAGES).getX()));
			isEnd = true;
		}
		else
		{
			for (int x = 0; x < NUM_IMAGES; x++)
			{
				backgroundImages.get(x).shift(v, 0);
				
			}
			
			for (int f = 0; f < NUM_FIRES; f++)
			{
				fires.get(f).shift(v,0);
			}
			
			source.shift(v, 0);
			destination.shift(v, 0);
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
			if (backgroundImages.get(x) != null)
			{
				backgroundImages.get(x).draw(drawer,700,500);
			}
		}
		
		for (int f = 0; f < NUM_FIRES; f++)
		{
			fires.get(f).draw(drawer);
		}
		source.draw(drawer);
		destination.draw(drawer);
		// drawer.background(0,0,255);
	}
	
	/**
	 * @return ArrayList of fires this Background object contains
	 */
	public ArrayList<Fire> getFires()
	{
		return fires;
	}
	
	
	/**
	 * @return total number of fires in the simulation
	 */
	public int getFireCount() {
		return NUM_FIRES;
	}
	
	
	/**
	 * @return returns the number of fires extinguished
	 */
	public int getFiresExtinguished() 
	{
		int fireCount = 0;
		
		for (Fire f : fires) 
		{
			if (f.isExtinguished()) 
			{
				fireCount++;
			}
		}
		
		return fireCount;
	}
	
	/**
	 * @return returns number of images in background
	 */
	public int getNumImages() 
	{
		return NUM_IMAGES;
	}
	
	/**
	 * @return ground level of the background
	 */
	public int getGroundLevel()
	{
		return GROUND_LEVEL;
	}
	
	/**
	 * @return source runway object
	 */
	public Runway getSourceRunway()
	{
		return source;
	}
	
	/**
	 * @return destination runway object
	 */
	public Runway getDestinationRunway()
	{
		return destination;
	}
	
	/**
	 * @return true if last background image is visible, false otherwise
	 */
	public boolean getIsEnd() {
		return isEnd;
	}
}
