import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	
	private Dial dial;
	private Cockpit c;
	
	/**
	 * Constructor to initial DrawingSurface object with a dial
	 * @param d Dial to be added to DrawingSurface object
	 */
	public DrawingSurface(Dial d) {
		dial = d;
		c = new Cockpit(dial);
	}
	
	/**
	 * Draws components of DrawingSurface object
	 */
	public void draw() {
		c.draw(this);
	}
	
	/**
	 * Acts on detection of pressed keys
	 */
	public void keyPressed() {
		if (keyCode == RIGHT && !dial.reachedMax()) {
			dial.addSpeed(10);
		}
		else if (keyCode == LEFT && !dial.reachedMin()) {
			dial.addSpeed(-10);
		}
		else if (keyCode == UP) {
			c.changeAltitude(5);
		}
		else if (keyCode == DOWN) {
			c.changeAltitude(-5);
		}
	}
}
