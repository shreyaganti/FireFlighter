import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class represents an airplane with an (x,y) coordinate and velocities in the x and y direction
 * 
 * @author Ashwini Suriyaprakash
 * @version 5/8/19
 */
public class Airplane 
{
	private PImage planeImage;
	private double x,y,vx,vy;
	private ArrayList<WaterSpray> sprayedWater;
	public static final int WATER_SPRAY_MAX = 40;
	// 0 for ground (about to take off), 1 for in the air, 2 for ground (after landing)
	private int status;
	private Cockpit cockpit;
	
	private double trueX;
	
	/**
	 * Creates a instance of an Airplane object with horizontal and vertical velocities set to 0, null plane image, and a status of being on the ground
	 * @param x x coordinate of upper left corner of plane
	 * @param y y coordinate of upper left corner of plane
	 * @param c Cockpit object that the plane will have
	 */
	public Airplane(double x, double y, Cockpit c)
	{
		this.x = x;
		this.y = y;
		this.vx = 0;
		this.vy = 0;
		this.trueX = 0;
		this.planeImage = null;
		this.sprayedWater = new ArrayList<WaterSpray>();
		this.status = 0;
		cockpit = c;
	}
	
	/**
	 * Loads the plane image from file and sets up the plane's cockpit
	 * @param drawer PApplet required for the setup
	 */
	public void setup(PApplet drawer) 
	{
		planeImage = drawer.loadImage("images/plane.png");
		planeImage.resize(120, 60);
		cockpit.setup(drawer);
	}
	
	/**
	 * Draws Airplane object to a processing PApplet
	 * @param drawer PApplet on which Airplane object is drawn
	 * @pre drawer can't be null
	 */
	public void draw(PApplet drawer)
	{
		drawer.image(planeImage, (float)(x), (float)(y));
		cockpit.draw(drawer);
	}
	
	/**
	 * @return y coordinate of Airplane object
	 */
	public double getY()
	{
		return y;
	}
	
	/**
	 * @return x coordinate of Airplane object
	 */
	public double getX()
	{
		return x;
	}
	
	/**
	 * Moves Airplane to another x,y location
	 * @param x1 x location to move the Airplane to
	 * @param y1 y location to move the Airplane to
	 */
	public void move(double x1, double y1)
	{
		this.x = x1;
		this.y = y1;
	}
	
	/**
	 * Causes the Airplane to act based on its velocities and adjusts the cockpit dial appropriately
	 */
	public void act()
	{
		move(x,y+vy);
		trueX+=vx;
		if (Math.abs(y+vy) <=0.01) 
		{
			cockpit.setAltitude(0);
		}
		else
		{
			cockpit.setAltitude((int) (-1*(y+vy-360)));
		}
		
			
	}
	
	/**
	 * Increases Airplane's horizontal velocity by a certain amount
	 * @param offset amount to increase horizontal velocity by
	 */
	public void increaseSpeed(double offset)
	{
		if (offset < 0 && vx >= -offset)
		{
			vx+=offset;
		}
		else if (offset > 0)
		{
			vx+=offset;
		}
		
		if (offset < 0 && !cockpit.getDial().reachedMin())
		{
			cockpit.getDial().addSpeed(10*offset);
		}
		else if (offset > 0 && !cockpit.getDial().reachedMax())
		{
			cockpit.getDial().addSpeed(10*offset);
		}
			
	}
	
	/**
	 * Moves the Airplane up by a certain amount, only if it is ready for take off or is already in the sky
	 * @param num amount to move the airplane up by
	 */
	public void ascend(double num)
	{
		if (isReadyForTakeOff() || status == 1)
		{
			status = 1;
			y-=num;
			vy = 3;
		}
	}
	
	/**
	 * @return horizontal velocity of the plane (in the x direction)
	 */
	public double getVelocityX()
	{
		return vx;
	}
	
	/**
	 * @return vertical velocity of the plane (in the y direction)
	 */
	public double getVelocityY()
	{
		return vy;
	}
	
	private boolean isReadyForTakeOff()
	{
		if (status == 0 && vx > 20)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Sets the status of the plane (0 for on the ground before take off, 1 for in the air, and 2 for on the ground after landing)
	 * @param val status to set the plane to
	 * @pre val can only be 0, 1, or 2
	 */
	public void setStatus(int val)
	{
		status = val;
	}
	
	/**
	 * @return the status of the plane (0 for on the ground before take off, 1 for in the air, and 2 for on the ground after landing)
	 */
	public int getStatus()
	{
		return status;
	}
	
	/**
	 * @return Arraylist containing the WaterSpray objects the plane has fired
	 */
	public ArrayList<WaterSpray> getSprayedWater()
	{
		return sprayedWater;
	}
	
	/**
	 * Sprays a WaterSpray with vertical velocity downward, if water spray amount the plane contains hasn't run out
	 */
	public void spray(PApplet drawer)
	{
		if (sprayedWater.size() < WATER_SPRAY_MAX)
		{
			WaterSpray spray = new WaterSpray(x,y,-1,20);
			spray.setup(drawer);
			sprayedWater.add(spray);
		}
	}
	
	/**
	 * @return returns the true X value of the plane as if it was moving
	 */
	public double getTrueX() {
		return trueX;
	}
	
	/**
	 * @return Cockpit object in Airplane
	 */
	public Cockpit getCockpit() {
		return cockpit;
	}
	
	/**
	 * @return the width of the plane
	 */
	public int getWidth()
	{
		return planeImage.width;
	}
	
	public boolean isPlaneOnRunway(Runway r)
	{
		if (Math.abs(getY()-r.getY()) < 0.0001 && getX() >= r.getX() && getX() <= r.getX()+r.getWidth())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
