import processing.core.PApplet;

/**
 * This class represents a flight simulation (2d side view), containing the Airplane and Background objects.
 * 
 * @author Ashwini Suriyaprakash, Shreya Ganti, Rujuta Swadi
 * @version 5/8/19
 */
public class FlightSimulation
{
	private Airplane plane;
	private Background scenery;
	private int timeRemaining;
	
	/**
	 * Creates a FlightSimulation with a Background object and Airplane object at coordinates (500,360) 
	 */
	public FlightSimulation()
	{
		scenery = new Background();
		plane = new Airplane(500,scenery.getGroundLevel(), new Cockpit(new Dial(150,100)));
		timeRemaining = -1;
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
		
		plane.act();
		plane.draw(drawer);
		for (WaterSpray w: plane.getSprayedWater())
		{
			w.act();
			w.draw(drawer);
		}
		
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
		
		if (plane.getStatus() == 1 && Math.abs(plane.getY()-scenery.getGroundLevel()) <= 0.000001)
		{
			plane.setStatus(2);
		}
		
		// System.out.println("Status: " + plane.getStatus());
		// System.out.println("Y coordinate: " + plane.getY());
		
		// Draws useful data
		drawer.fill(0);
		drawer.fill(0);
		drawer.textSize(13);
		drawer.text("Water Spray Count Left:" + (plane.WATER_SPRAY_MAX - plane.getSprayedWater().size()), 305, 20);
		drawer.text("Fires Extinguished: " + scenery.getFiresExtinguished() + "/" + scenery.getFireCount(), 305, 50);
		
		
		double distanceLeft = scenery.getNumImages()*700 - plane.getTrueX() - plane.getWidth();
		timeRemaining = (int) (distanceLeft/plane.getVelocityX());
		int minutesLeft = timeRemaining/60;
		int secondsLeft = timeRemaining%60;
		String sec = "";
		String min = "" + minutesLeft;
		
		if (secondsLeft < 10) 
		{
			sec = "0" + secondsLeft;
		} 
		else 
		{
			sec = "" + secondsLeft;
		}
		
		if (secondsLeft < 0) 
		{
			sec = "0";
		}
		
		if (plane.getVelocityX() <= 0) 
		{
			drawer.text("Estimated time until landing: UNKNOWN", 305, 80);
		} else 
		{
			drawer.text("Estimated time until landing: "+ min + ":" + sec, 305, 80); 
		}
		
		// Unsuccessful takeoff (if plane is on ground and is not on source runway)
		if (plane.getStatus() == 0 && !plane.isPlaneOnRunway(scenery.getSourceRunway()))
		{
			drawer.text("Unsuccessful takeoff", 305, 100);
		}
		
		if (plane.getStatus() == 2 && !plane.isPlaneOnRunway(scenery.getDestinationRunway()))
		{
			drawer.text("Unsuccessful landing", 305, 110);
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
