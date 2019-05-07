import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	
	private Dial dial;
	
	public DrawingSurface(Dial d) {
		dial = d;
	}
	
	public void draw() {
		dial.draw(this);
	}
}
