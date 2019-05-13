import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 * Represents a LocationTracker which tracks the plane's flight
 * @author Shreya Ganti, Ashwini Suriyaprakash
 * @version 5/12/19
 *
 */
public class LocationTracker {
	
	private String source, destination;
	//private double x,y;
	private PImage map;
	private int x,y;
	
	/**
	 * Constructor to initialize location and source and destination labels of LocationTracker
	 * @param x x-coordinate of beginning of LocationTracker
	 * @param y y-coordinate of beginning of LocationTracker
	 * @param s name of source airport
	 * @param d name of destination airport
	 * Creates a new LocationTracker object
	 * @param x x coordinate of tracker
	 * @param y y coordinate of tracker
	 * @param s source airport
	 * @param d destination airport
	 */
	public LocationTracker(int x, int y, String s, String d) {
		source = s;
		destination = d;
		this.x = x;
		this.y = y;
		this.map = null;
	}
	
	/*/**
	 * Draws the LocationTracker
	 * @param p PApplet object used to draw the LocationTracker
	 *
	public void draw(PApplet p) {
		p.line(75, (float)y, 225, (float)y);
		p.line(75, (float)(y+5), 75, (float)(y-5));
		p.line(225, (float)(y+5), 225, (float)(y-5));
		p.text(source, 75, (float)(y+7));
		p.text(destination, 225, (float)(y+7));
		//System.out.println(source+ "  :  " +destination);
		p.ellipseMode(p.RADIUS);
		p.ellipse((float)x, (float)y, 10, 10);
	}*/
	/**
	 * Downloads map image from Internet
	 * @param drawer PApplet used to setup the LocationTracker
	 */
	public void setup(PApplet drawer)
	{
		Scanner scan = null;
		URL reader = null;
		String url = "http://www.gcmap.com/mapui?P=" + source + ",+" + destination;
		
		try
		{
			String output = "";
			
			reader = new URL(url);
			scan = new Scanner(reader.openStream());
			
			while (scan.hasNextLine())
			{
				String line = scan.nextLine();
				output+=line+"\n";
			}
			
			// System.out.println(output);
			
			int i = output.indexOf("id=\"map_div\"><img src=");
			int start = i+23;
			int end = output.indexOf("\"", start+1);
			
			System.out.println(output.substring(i+22,i+100));
			
			String imgURL = "http://www.gcmap.com" + output.substring(start, end);
			System.out.println("URL: " + imgURL);
			map = drawer.loadImage(imgURL, "png");
			map.resize(300,200);
			// map.loadPixels();
			// System.out.println(Arrays.toString(map.pixels));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			// run no matter what happens
			if (scan != null)
			{
				scan.close();
			}
		}
	}
	
	/**
	 * Draws the LocationTracker object
	 * @param drawer PApplet to draw the LocationTracker object on
	 **/
	public void draw(PApplet drawer) 
	{
		if (map != null)
		{
			drawer.image(map,0,300);
		}
		drawer.line(100, y, 200, y);
		drawer.ellipseMode(drawer.RADIUS);
		drawer.ellipse(x, y, 10, 10);
	}
	
	/**
	 * Changes x coordinate of the LocationTracker
	 * @param a x offset to shift by
>>>>>>> branch 'master' of https://github.com/shreyaganti/FireFlighter.git
	 */
	public void changeX(double a) {
		x+=a;
	}
	
	/**
	 * Sets the source airport
	 * @param s the new source airport
	 */
	public void setSource(String s) {
		source = s;
	}
	
	/**
	 * Sets the destination airport
	 * @param s the new destination airport
	 */
	public void setDestination(String d) {
		destination = d;
	}
}
