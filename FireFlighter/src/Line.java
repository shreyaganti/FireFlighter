// Name: Ashwini Suriyaprakash
// Date: 9/6/18
// Period: 4
// Description: The Line class represents a line segment defined by two endpoint coordinates.
// It provides methods to change the endpoint of the segment and find if two line segments intersect.

import processing.core.PApplet;

public class Line 
{
	// Fields:
	double xCoord1, yCoord1, xCoord2, yCoord2;
	
	// Constructor:
	public Line(double x1, double y1, double x2, double y2)
	{
		// Initializing fields
		xCoord1 = x1;
		yCoord1 = y1;
		xCoord2 = x2;
		yCoord2 = y2;
	}
	
	// Methods:
	
	// Method "setPoint2" changes the second end point of the segment
	public void setPoint2(double x2, double y2)
	{
		xCoord2 = x2;
		yCoord2 = y2;
	}
	
	// Method "draw" draws the line on the window
	public void draw(PApplet drawer)
	{
		drawer.line((float)xCoord1, (float)yCoord1, (float)xCoord2, (float)yCoord2);
	}
	
	// Method "getX1" gets the x value of the first end point of the line segment
	public double getX1()
	{
		return xCoord1;
	}
	
	// Method "getY1" gets the y value of the first end point of the line segment
	public double getY1()
	{
		return yCoord1;
	}
	
	// Method "getX2" gets the x value of the second end point of the line segment
	public double getX2()
	{
		return xCoord2;
	}
	
	// Method "getY2" gets the y value of the second end point of the line segment
	public double getY2()
	{
		return yCoord2;
	}
	
	// Method "calculateSlope" calculates the slope of the line segment
	public double calculateSlope()
	{
		return (getY1()-getY2())/(getX1()-getX2());
	}
	
	// Method "isVertical" returns true if the line segment is vertical and false otherwise
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
	
	// Method "isHorizontal" returns true if the line segment is horizontal and false otherwise
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
	
	// Method "calculateYIntercept" returns the y intercept of the line containing this line segment
	public double calculateYIntercept()
	{
		return (getY1()-calculateSlope()*getX1());
	}
	
	public double getLength()
	{
		double length = Math.pow((xCoord1-xCoord2),2) + Math.pow((yCoord1-yCoord2), 2);
		length = Math.pow(length, 0.5);
		return length;
	}
}