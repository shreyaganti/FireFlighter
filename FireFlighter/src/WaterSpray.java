import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class represents a single spray of water, which the plane can shoot at the fires
 * 
 * @author Ashwini Suriyaprakash
 * @version 5/5/19
 */
public class WaterSpray 
{
	private double x,y,vx,vy;
	private PImage waterImage;
	private boolean isHit = false;
	
	public WaterSpray(double x, double y, double vx, double vy)
	{
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
		this.waterImage = null;
	}
	
	public void setup(PApplet drawer)
	{
		waterImage = drawer.loadImage("images/water.png");
		waterImage.resize(25, 25);
		
	}
	
	public void draw(PApplet drawer)
	{
		if (!isHit) 
		{
			drawer.image(waterImage, (float)(x), (float)(y));
		}
	}
	
	/**
	 * @return y coordinate of WaterSpray object
	 */
	public double getY()
	{
		return y;
	}
	
	/**
	 * @return x coordinate of WaterSpray object
	 */
	public double getX()
	{
		return x;
	}
	
	/**
	 * Returns width of water spray image
	 * @return Width of one water spray droplet
	 */
	public double getWidth() {
		return waterImage.width;
	}
	
	/**
	 * Returns height of water spray image
	 * @return Height of one water spray droplet
	 */
	public double getHeight() {
		return waterImage.height;
	}
	
	/**
	 * Moves WaterSpray to another x,y location
	 * @param x1 x location to move the Airplane to
	 * @param y1 y location to move the Airplane to
	 */
	public void move(double x1, double y1)
	{
		this.x = x1;
		this.y = y1;
	}
	
	/**
	 * Causes the WaterSpray to act based on its velocities
	 */
	public void act()
	{
		move(x+vx,y+vy);
	}
	
	/**
	 * @return horizontal velocity of the WaterSpray (in the x direction)
	 */
	public double getVelocityX()
	{
		return vx;
	}
	
	/**
	 * @return vertical velocity of the WaterSpray (in the y direction)
	 */
	public double getVelocityY()
	{
		return vy;
	}
	
	
	
	public void isHit(Fire f) 
	{
		if (x >= f.getX() && x <= f.getX()+f.getWidth() && y+waterImage.height>=f.getY()) 
		{
			isHit = true;
			f.extinguish();
		}
	}
}
