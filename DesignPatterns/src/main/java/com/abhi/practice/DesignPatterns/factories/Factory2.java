package com.abhi.practice.DesignPatterns.factories;


//Nested Factory Keeping Constructor Private
public class Factory2 {
	public static void main(String[] args) {
		Point point = Point.Factory.newCartesianPoint(2, 3);
	}
}


class Point {
	
	public static class Factory{
		
		public static Point newCartesianPoint(double x, double y) {
			return new Point(x, y);
		}

		public static Point newPolarPoint(double rho, double theta) {
			return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
		}
	}
	
	private double x, y;
	 
	private Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}