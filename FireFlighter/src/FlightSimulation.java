import javax.swing.JOptionPane;

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
		
		if (plane.getStatus() == 0 && !plane.isPlaneOnRunway(scenery.getSourceRunway()))
		{
			JOptionPane.showMessageDialog(null, "GAME OVER -- UNSUCCESSFUL TAKEOFF", "ERROR", JOptionPane.ERROR_MESSAGE);
	    	System.exit(0);	
		}
		if (plane.getStatus() == 1 && plane.getY() >= scenery.getGroundLevel())
		{
			plane.setStatus(2);
			// System.out.println("y coordinate: " + plane.getY());
			// System.out.println("y coordinate: " + plane.getY());
			if (!plane.isPlaneOnRunway(scenery.getDestinationRunway()))
			{
				JOptionPane.showMessageDialog(null, "GAME OVER -- UNSUCCESSFUL LANDING", "GAME OVER", JOptionPane.ERROR_MESSAGE);
			    System.exit(0);
			}
			else
			{
				if (plane.getVelocityX() > 30)
				{
					JOptionPane.showMessageDialog(null, "GAME OVER -- CRASH LANDING: PLANE SPEED WAS TOO HIGH", "GAME OVER", JOptionPane.ERROR_MESSAGE);
				    System.exit(0);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "GAME OVER -- SUCCESSFUL LANDING", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
				    System.exit(0);
				}
			}
		}
		
		// System.out.println("Status: " + plane.getStatus());
		// System.out.println("Y coordinate: " + plane.getY());
		
		// Draws useful data
		drawer.fill(0);
		drawer.fill(0);
		drawer.textSize(13);
		drawer.text("Water Spray Count Left:" + (plane.WATER_SPRAY_MAX - plane.getSprayedWater().size()), 305, 20);
		drawer.text("Fires Extinguished: " + scenery.getFiresExtinguished() + "/" + scenery.getFireCount(), 305, 50);
		
		

	    int water = plane.WATER_SPRAY_MAX;
	    int waterDone = plane.getSprayedWater().size();
	    
	   

	    if (water - waterDone <= 0)
	    {
	    	JOptionPane.showMessageDialog(null, "GAME OVER -- YOU'RE OUT OF WATER", "ERROR", JOptionPane.ERROR_MESSAGE);
	    	System.exit(0);
		}
		
		double distanceLeft = scenery.getNumImages()*700 - plane.getTrueX() - plane.getWidth();

		timeRemaining = (int) (distanceLeft/plane.getVelocityX());
		if (plane.getStatus() == 1 && !scenery.getIsEnd()) {
			plane.getCockpit().getLocTrack().changeX(plane.getVelocityX()*375/(700*scenery.getNumImages()));
		}
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
	
	/**
	 * @return Background of FlightSimulation
	 */
	public Background getScenery() {
		return scenery;
	}
}

