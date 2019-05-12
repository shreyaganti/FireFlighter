import processing.core.PApplet;

public class LocationTracker {
	
	private String source, destination;
	private int x,y;
	
	public LocationTracker(int x, int y, String s, String d) {
		source = s;
		destination = d;
		this.x = x;
		this.y = y;
	}
	
	public void draw(PApplet p) {
		p.line(100, y, 200, y);
		p.ellipseMode(p.RADIUS);
		p.ellipse(x, y, 10, 10);
	}
	
	public void changeX(double a) {
		x+=a;
	}
	
}
