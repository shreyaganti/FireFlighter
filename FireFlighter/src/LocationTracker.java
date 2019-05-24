import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Represents a LocationTracker which tracks the plane's flight
 * @author Shreya Ganti, Ashwini Suriyaprakash
 * @version 5/22/19
 */
public class LocationTracker 
{
	
	private String source, destination;
	private PImage map, planeMarker;
	private double x,y,fractionOfRouteCovered;
	private Line route;
	
	/**
	 * Constructor to initialize location and source and destination labels of LocationTracker
	 * @param x x-coordinate of beginning of LocationTracker
	 * @param y y-coordinate of beginning of LocationTracker
	 * @param s name of source airport
	 * @param d name of destination airport
	 */
	public LocationTracker(double x, double y, String s, String d) {
		source = s;
		destination = d;
		this.x = x;
		this.y = y;
		this.fractionOfRouteCovered = 0;
		this.map = null;
		this.route = null;
	}
	
	/**
	 * Downloads map image from Internet and set up the route
	 * @param drawer PApplet used to setup the LocationTracker
	 */
	public void setup(PApplet drawer)
	{
		planeMarker = drawer.loadImage("images/smallplane.png");
		planeMarker.resize(20, 20);
		
		// Sets to null
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
			
			
			int i = output.indexOf("id=\"map_div\"><img src=");
			int start = i+23;
			int end = output.indexOf("\"", start+1);
			
			String imgURL = "http://www.gcmap.com" + output.substring(start, end);
			
			imgURL = imgURL.replaceAll("amp;", "");
			map = drawer.loadImage(imgURL, "png");
			map.resize(300,200);
			map.loadPixels();
			
			int count = 0;
			double sourceX = -1;
			double sourceY = -1;
			double destX = -1;
			double destY = -1;;
			for (int r = 0; r < map.width; r++)
			{
				for (int c = 0; c < map.height; c++)
				{
					int loc = r+c*map.width;
					boolean isRed = false;
					float red = drawer.red(map.pixels[loc]);
				    float green = drawer.green(map.pixels[loc]);
				    float blue = drawer.blue(map.pixels[loc]);
				    if (red > green && red > blue)
				    {
				    	isRed = true;
				    }
				    
					if (count == 0 && isRed)
					{
						sourceX = x+r;
						sourceY = y+c;
						count++;
						break;
					}
					if (count == 1 && isRed)
					{
						
						if (Math.abs(sourceX-(x+r)) > 10 || Math.abs(sourceY-(y+c)) > 10)
						{
							destX = x+r;
							destY = y+c;
							count++;
						}
					}
				}
			}
			route = new Line(sourceX,sourceY, destX,destY);
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
			// System.out.println("Map is not null");
			drawer.image(map,(float)x,(float)y);
		}
		
		if (planeMarker != null)
		{
			double routeCovered = fractionOfRouteCovered*route.getLength();
			double angle = Math.atan(route.calculateSlope());
			double markerX = routeCovered*Math.cos(angle)+route.getX1();
			double markerY = routeCovered*Math.sin(angle)+route.getY1();
			markerX-=planeMarker.width/2;
			markerY-=planeMarker.height/2;
			drawer.pushMatrix();
			drawer.translate((float)markerX, (float)markerY);
			drawer.rotate((float)angle);
			drawer.translate(-(float)markerX, -(float)markerY);
			drawer.image(planeMarker,(float)markerX, (float)markerY);
			drawer.popMatrix();
			for (double x = route.getX1(); x <= markerX; x+=5)
			{
				double y = x*route.calculateSlope()+route.calculateYIntercept();
				drawer.fill(0,0,255);
				drawer.ellipse((float)x,(float)y,(float)0.5,(float)0.5);
			}
		}
	}
	
	/**
	 * Sets the fraction of the route the plane has covered
	 * @param frac the fraction of the route the plane has covered
	 */
	public void setFractionOfRouteCovered(double frac) 
	{
		fractionOfRouteCovered = frac;
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
	 * @param d the new destination airport
	 */
	public void setDestination(String d) 
	{
		destination = d;
	}
	
	/**
	 * @return source airport
	 */
	public String getSource() 
	{
		return source;
	}
	
	/**
	 * @return destination airport
	 */
	public String getDestination() 
	{
		return destination;
	}
}
