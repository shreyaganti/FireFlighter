import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import processing.core.PApplet;

/**
 * This class represents the pilot’s view of the flight simulation and extends PApplet
 * 
 * @author Ashwini Suriyaprakash, Shreya Ganti, Rujuta Swadi
 * @version 5/8/19
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
	 * @post if left key pressed, Airplane horizontal velocity decreases by 2
	 * @post if right key pressed, Airplane horizontal velocity increases by 2
	 * @post if up key pressed, Airplane moves up by 2 units
	 * @post if down key pressed, Airplane moves down by 2 units
	 * @post if space key pressed, Airplane sprays water
	 */
	public void keyPressed() 
	{
		if (keyCode == KeyEvent.VK_LEFT)
		{

			flightSim.getPlane().increaseSpeed(-2);
		}
		else if (keyCode == KeyEvent.VK_RIGHT)
		{
			flightSim.getPlane().increaseSpeed(4);
			//double distanceLeft = flightSim.getScenery().getNumImages()*700 - flightSim.getPlane().getTrueX() - flightSim.getPlane().getWidth();
			//flightSim.getPlane().getCockpit().getLocTrack().changeX(1/distanceLeft);
			
		}
		else if (keyCode == KeyEvent.VK_UP)
		{
			flightSim.getPlane().ascend(5);
		}
		else if (keyCode == KeyEvent.VK_DOWN)
		{
			flightSim.getPlane().ascend(-5);
		}
		else if (keyCode == KeyEvent.VK_SPACE)
		{
			flightSim.getPlane().spray(this);
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
