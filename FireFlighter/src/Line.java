import processing.core.PApplet;

/**
 * This class represents a line segment defined by two end points. It provides methods to change one end point of the segment and perform various calculations.
 * @author Ashwini Suriyaprakash
 * @version 5/22/19
 */
public class Line 
{
	private double xCoord1, yCoord1, xCoord2, yCoord2;
	
	/**
	 * Creates a new line object with two endpoints
	 * @param x1 x coordinate of first end point
	 * @param y1 y coordinate of first end point
	 * @param x2 x coordinate of second end point
	 * @param y2 y coordinate of second end point
	 */
	public Line(double x1, double y1, double x2, double y2)
	{
		// Initializing fields
		xCoord1 = x1;
		yCoord1 = y1;
		xCoord2 = x2;
		yCoord2 = y2;
	}
	
	/**
	 * Changes the second end point of the line segment
	 * @param x2 new x coordinate of line segment end point
	 * @param y2 new y coordinate of line segment end point
	 */
	public void setPoint2(double x2, double y2)
	{
		xCoord2 = x2;
		yCoord2 = y2;
	}
	
	/**
	 * Draws Line object
	 * @param drawer PApplet to draw the line segment on
	 */
	public void draw(PApplet drawer)
	{
		drawer.line((float)xCoord1, (float)yCoord1, (float)xCoord2, (float)yCoord2);
	}
	
	/**
	 * @return x coordinate of first end point
	 */
	public double getX1()
	{
		return xCoord1;
	}
	
	/**
	 * @return y coordinate of second end point
	 */
	public double getY1()
	{
		return yCoord1;
	}
	
	/**
	 * @return x coordinate of second end point
	 */
	public double getX2()
	{
		return xCoord2;
	}
	
	/**
	 * @return y coordinate of second end point
	 */
	public double getY2()
	{
		return yCoord2;
	}
	
	/**
	 * Calculates slope of the Line
	 * @return slope of Line object
	 */
	public double calculateSlope()
	{
		return (getY1()-getY2())/(getX1()-getX2());
	}
	
	/**
	 * Checks if Line object is vertical
	 * @return true if it is vertical, false otherwise
	 */
	public boolean isVertical()
	{
		if (Math.abs(getX1() - getX2()) < 0.0000000001)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Checks if Line object is horizontal
	 * @return true if it is horizontal, false otherwise
	 */
	public boolean isHorizontal()
	{
		if (Math.abs(getY1()-getY2()) < 0.0000000001)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Returns a Line object specified by a coordinate, angle, and length
	 * @param x x coordinate of first end point
	 * @param y y coordinate of first end point
	 * @param angle angle in degrees from the horizontal
	 * @param length length of line segment
	 * @return Line object specified by parameters
	 */
	public static Line getLineFromAngle(double x, double y, double angle, double length)
	{
		Line l = new Line(x,y,x+Math.cos(angle*Math.PI/180)*length, y-Math.sin(angle*Math.PI/180)*length);
		return l;
	}
	
	/**
	 * Calculates y intercept of the Line object
	 * @return y intercept
	 */
	public double calculateYIntercept()
	{
		return (getY1()-calculateSlope()*getX1());
	}
	
	/**
	 * Calculates length of the Line object
	 * @return length of Line object
	 */
	public double getLength()
	{
		double length = Math.pow((xCoord1-xCoord2),2) + Math.pow((yCoord1-yCoord2), 2);
		length = Math.pow(length, 0.5);
		return length;
	}
}