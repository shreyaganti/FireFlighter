import processing.core.PApplet;

public class Cockpit 
{
	private Dial dial;
	private double altitude;
	
	public Cockpit() 
	{
		dial = new Dial(0,0);
	}
	
	public void draw(PApplet drawer)
	{
		dial.draw(drawer);
	}
}
