import processing.core.PApplet;
import processing.core.PImage;

public class Lightning 
{
	private PImage[] lightningImages;
	private final int GIF_COUNT = 5;
	private int lightningFrame;
	private double x,y;
	
	/**
	 * Creates a Lightning object that is not extinguished
	 * @param x x coordinate of the fire's center
	 * @param y y coordinate of the fire's center
	 */
	public Lightning(double x, double y)
	{
		this.x = x;
		this.y = y;
		this.lightningImages = new PImage[GIF_COUNT];
		this.lightningFrame = 0;
	}
	
	/**
	 * Loads flame and smoke images
	 * @param drawer PApplet needed for the setup
	 */
	public void setup(PApplet drawer)
	{
		for (int i = 0; i < GIF_COUNT; i++) 
		{
			// images[i] = drawer.loadImage("images//fire.gif");
			lightningImages[i] = drawer.loadImage("images/lightning" + (i+1) + ".gif");
			lightningImages[i].resize(100, 100);
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
		lightningFrame = (lightningFrame+1) % GIF_COUNT;
		drawer.image(lightningImages[lightningFrame], (float)(x-getWidth()/2), (float)(y-getHeight()/2));
	}
	
	/**
	 * @return width of the fire
	 */
	public double getWidth() 
	{
		return lightningImages[0].width;
	}
	
	/**
	 * @return height of the fire
	 */
	public double getHeight() 
	{
		return lightningImages[0].height;
	}
	
	
	/**
	 * @return x coordinate of the fire
	 */
	public double getX() 
	{
		return x;
	}
	
	/**
	 * @return y coordinate of the fire
	 */
	public double getY() 
	{
		return y;
	}
	
	/**
	 * Checks if this lightning object struck a plane
	 * @param p Airplane to check a collision with
	 * @return true if lightning hit the plane, false otherwise
	 */
	public boolean hasHit(Airplane p) {
		if (x>=p.getX() && x<=p.getX()+p.getWidth() && y>=p.getY()&&y<=p.getHeight()+p.getY())
			return true;
		return false;
	}
}
