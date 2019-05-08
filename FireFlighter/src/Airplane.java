import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class represents an airplane with an (x,y) coordinate and velocities in the x and y direction
 * 
 * @author Ashwini Suriyaprakash
 * @version 5/5/19
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
	
	/**
	 * Creates a instance of an Airplane object with horizontal and vertical velocities set to 0, null plane image, and a status of being on the ground
	 * @param x x coordinate of upper left corner of plane
	 * @param y y coordinate of upper left corner of plane
	 */
	public Airplane(double x, double y, Cockpit c)
	{
		this.x = x;
		this.y = y;
		this.vx = 0;
		this.vy = 0;
		this.planeImage = null;
		this.sprayedWater = new ArrayList<WaterSpray>();
		this.status = 0;
		cockpit = c;
	}
	
	/**
	 * Draws Airplane object to a processing PApplet
	 * @param drawer PApplet on which Airplane object is drawn
	 * @pre drawer can't be null
	 */
	public void draw(PApplet drawer)
	{
		planeImage = drawer.loadImage("images/plane.png");
		planeImage.resize(120, 60);
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
	 * Causes the Airplane to act based on its velocities
	 */
	public void act()
	{
		move(x,y+vy);
		cockpit.setAltitude(-1*(y+vy-360));
	}
	
	/**
	 * Increases Airplane's horizontal velocity by a certain amount
	 * @param offset amount to increase horizontal velocity by
	 */
	public void increaseSpeed(double offset)
	{
		vx+=offset;
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
			cockpit.changeAltitude(num);
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
	 * @return arraylist containing the WaterSpray objects the plane has fired
	 */
	public ArrayList<WaterSpray> getSprayedWater()
	{
		return sprayedWater;
	}
	
	/**
	 * Sprays a WaterSpray with vertical velocity downward, if water spray amount the plane contains hasn't run out
	 */
	public void spray()
	{
		if (sprayedWater.size() < WATER_SPRAY_MAX)
		{
			WaterSpray spray = new WaterSpray(x,y,-1,10);
			sprayedWater.add(spray);
		}
	}
	
	/**
	 * Returns Cockpit object
	 * @return Cockpit object in Airplane
	 */
	public Cockpit getCockpit() 
	{
		return cockpit;
	}
}
