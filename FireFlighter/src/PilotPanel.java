import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import processing.core.PApplet;

/**
 * This class represents the pilot's view of the flight simulation and extends PApplet
 * 
 * @author Ashwini Suriyaprakash, Shreya Ganti, Rujuta Swadi
 * @version 5/22/19
 */
public class PilotPanel extends PApplet
{
	private FlightSimulation flightSim;
	private final float DRAWING_WIDTH = 1000, DRAWING_HEIGHT = 500;
	
	/**
	 * Creates a PilotPanel object, which contains a FlightSimulation object
	 */
	public PilotPanel()
	{
		super();
		flightSim = new FlightSimulation();
		
	}
	
	/**
	 * Sets up this PApplet
	 */
	public void setup() 
	{
		flightSim.setup(this);
	}
	
	/**
	 * Acts based on keys pressed
	 * @post if left key pressed, Airplane horizontal velocity decreases by 4
	 * @post if right key pressed, Airplane horizontal velocity increases by 4
	 * @post if up key pressed, Airplane moves up by 4 units
	 * @post if down key pressed, Airplane moves down by 4 units
	 * @post if space key pressed, Airplane sprays water
	 */
	public void keyPressed() 
	{
		if (keyCode == KeyEvent.VK_LEFT)
		{
			flightSim.getPlane().increaseSpeed(-4);
		}
		else if (keyCode == KeyEvent.VK_RIGHT)
		{
			flightSim.getPlane().increaseSpeed(4);
			//System.out.println(flightSim.getPlane().getVelocityX());
		}
		else if (keyCode == KeyEvent.VK_UP)
		{
			if (flightSim.getPlane().getY() > 5) 
			{
				flightSim.getPlane().ascend(4);
			}
			
		}
		else if (keyCode == KeyEvent.VK_DOWN)
		{
			if (flightSim.getPlane().getY() <= flightSim.getScenery().getGroundLevel()-4) 
			{
				flightSim.getPlane().ascend(-4);
			}
			
		}
		else if (keyCode == KeyEvent.VK_SPACE)
		{
			if (flightSim.getPlane().getStatus() == 1) 
			{
				flightSim.getPlane().spray(this);
			}
			
		}
	}
	
	/**
	 * Draws its FlightSimulation on its surface, allows scaling and resizability
	 */
	public void draw()
	{
		background(255);
		pushMatrix();
		pushStyle();
		float scaleW = width / DRAWING_WIDTH;
		float scaleH = height / DRAWING_HEIGHT;
		scale(scaleW,scaleH);
		flightSim.draw(this);
		popStyle();
		popMatrix();
	}
	
	/**
	 * @return FlightSimulation object in PilotPanel
	 */
	public FlightSimulation getFlightSim() {
		return flightSim;
	}

}
