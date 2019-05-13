import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PImage;

public class LocationTracker {
	
	private String source, destination;
	private PImage map;
	private int x,y;
	
	public LocationTracker(int x, int y, String s, String d) {
		source = s;
		destination = d;
		this.x = x;
		this.y = y;
		this.map = null;
	}
	
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
	
	public void draw(PApplet drawer) 
	{
		if (map != null)
		{
			drawer.image(map,x,y);
		}
		drawer.line(100, y, 200, y);
		drawer.ellipseMode(drawer.RADIUS);
		drawer.ellipse(x, y, 10, 10);
	}
	
	public void changeX(double a) {
		x+=a;
	}
	
}
