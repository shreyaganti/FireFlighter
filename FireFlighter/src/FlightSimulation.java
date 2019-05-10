import processing.core.PApplet;

/**
 * This class represents a flight simulation (2d side view), containing the Airplane and Background objects.
 * 
 * @author Ashwini Suriyaprakash, Shreya Ganti
 * @version 5/8/19
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
		plane = new Airplane(500,360, new Cockpit(new Dial(150,100)));
		scenery = new Background();
	}
	
	/**
	 * Sets up the Airplane and Background objects
	 * @param drawer PApplet object need for setup
	 */
	public void setup(PApplet drawer)
	{
		plane.setup(drawer);
		scenery.setup(drawer);
	}
	
	/**
	 * Draws this FlightSimulation object to a PApplet
	 * @param drawer Papplet used to draw FlightSimulation object
	 */
	public void draw(PApplet drawer)
	{
		drawer.pushStyle();
		drawer.pushMatrix();
		scenery.scrollBackgroundSideways(-plane.getVelocityX());
		scenery.draw(drawer);
		
		for (Fire f: scenery.getFires())
		{
			for (WaterSpray w: plane.getSprayedWater())
			{
				if (f.isHitByWaterSpray(w))
				{
					f.extinguish();
					w.consume();
				}
			}
		}
		
		drawer.fill(0);
		//drawer.rect(300, 0, 170, 30);
		drawer.fill(0);
		drawer.textSize(13);
		drawer.text("Water Spray Count Left:" + (plane.WATER_SPRAY_MAX - plane.getSprayedWater().size()), 305, 20);
		drawer.text("Fires Extinguished: " + scenery.getFiresExtinguished() + "/" + scenery.getFireCount(), 305, 50);
		plane.act();
		plane.draw(drawer);
		for (WaterSpray w: plane.getSprayedWater())
		{
			w.act();
			w.draw(drawer);
		}
		drawer.popStyle();
		drawer.popMatrix();
	}
	
	/**
	 * @return the Airplane object this FlightSimulation contains
	 */
	public Airplane getPlane()
	{
		return plane;
	}
}
