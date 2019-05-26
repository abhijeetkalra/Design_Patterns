/*package com.abhi.practice.DesignPatterns.factories;


//Introducing factory Method
public class Factory1 {
	public static void main(String[] args) {
		Point point = Point.newCartesianPoint(2, 3);
	}
}

enum CoordinateSystem {
	CARTESIAN, POLAR
}

class Point {
	private double x, y;
	// we can't define what exactly ia a and b, hence this looks ugly
	
	 * public Point(double a, double b, CoordinateSystem cs) { switch (cs) { case
	 * CARTESIAN: this.x = a; this.y = b; break; case POLAR: x = a * Math.cos(b); y
	 * = a * Math.sin(b); break; default: break; } }
	 

	// Wrong Approach
	
	 * public Point(double rho, double theta) { x = rho * Math.cos(theta); y = rho *
	 * Math.sin(theta); }
	 

	//Making constructor private, does not allow anyone to create objectfrom it
	private Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public static Point newCartesianPoint(double x, double y) {
		return new Point(x, y);
	}

	public static Point newPolarPoint(double rho, double theta) {
		return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
	}

}*/