import processing.core.PApplet;

/**
 * This class represents a flight simulation (2d side view), containing the Airplane, Fire, Weather, and Background objects.
 * 
 * @author Ashwini Suriyaprakash
 * @version 5/5/19
 */
public class FlightSimulation
{
	private Airplane plane;
	private Background scenery;
	
	/**
	 * Creates a FlightSimulation with a Background object and Airplane object at coordinates (500,360) 
	 */
	public FlightSimulation()
	{
		plane = new Airplane(500,360);
		scenery = new Background();
	}
	
	/**
	 * Draws this FlightSimulation object to a PApplet
	 * @param drawer Papplet used to draw FlightSimulation object
	 */
	public void draw(PApplet drawer)
	{
		scenery.scrollBackgroundSideways(plane.getVelocityX());
		scenery.draw(drawer);
		drawer.fill(0);
		drawer.rect(300, 0, 170, 30);
		drawer.fill(255);
		drawer.textSize(13);
		drawer.text("Water Spray Count Left:" + (plane.WATER_SPRAY_MAX - plane.getSprayedWater().size()), 305, 20);
		plane.act();
		plane.draw(drawer);
		for (WaterSpray w: plane.getSprayedWater())
		{
			w.act();
			w.draw(drawer);
		}
	}
	
	/**
	 * @return the Airplane object this FlightSimulation contains
	 */
	public Airplane getPlane()
	{
		return plane;
	}
}
