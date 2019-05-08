import java.awt.event.KeyEvent;
import processing.core.PApplet;

/**
 * This class represents the pilot’s view of the flight simulation and cockpit and IS-A PApplet
 * 
 * @author Ashwini Suriyaprakash
 * @version 5/5/19
 */
public class PilotPanel extends PApplet
{
	private FlightSimulation flightSim;
	private Cockpit cockpit;
	private final float DRAWING_WIDTH = 1000, DRAWING_HEIGHT = 500;
	
	/**
	 * Creates a PilotPanel object, which contains a FlightSimulation object
	 */
	public PilotPanel()
	{
		flightSim = new FlightSimulation();
		cockpit = new Cockpit(new Dial(100,100));
	}
	
	/**
	 * Acts based on keys pressed
	 * @post if left key pressed, Airplane horizontal velocity decreases by 2
	 * @post if right key pressed, Airplane horizontal velocity increases by 2
	 * @post if up key pressed, Airplane moves up by 2 units
	 * @post if down key pressed, Airplane moves down by 2 units
	 */
	public void keyPressed() 
	{
		if (keyCode == KeyEvent.VK_LEFT)
		{
			flightSim.getPlane().increaseSpeed(-2);
			if (!cockpit.getDial().reachedMin())
				cockpit.changeSpeed(10);
		}
		else if (keyCode == KeyEvent.VK_RIGHT)
		{
			flightSim.getPlane().increaseSpeed(2);
			if (!cockpit.getDial().reachedMax())
				cockpit.changeSpeed(-10);
		}
		else if (keyCode == KeyEvent.VK_UP)
		{
			flightSim.getPlane().ascend(2);
			cockpit.changeAltitude(2);
		}
		else if (keyCode == KeyEvent.VK_DOWN)
		{
			flightSim.getPlane().ascend(-2);
			cockpit.changeAltitude(-2);
		}
		else if (keyCode == KeyEvent.VK_SPACE)
		{
			flightSim.getPlane().spray();
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
		cockpit.draw(this);
		popStyle();
		popMatrix();
	}
}
