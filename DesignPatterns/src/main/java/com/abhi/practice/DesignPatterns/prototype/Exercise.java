package com.abhi.practice.DesignPatterns.prototype;

public class Exercise {
	
	public static void main(String[] args) {
		Line l1 = new Line(new Point(2, 3), new Point(4, 5));
		Line l2 = l1.deepCopy();
		l2.start.x = 10;
		
		System.out.println(l1);
		System.out.println(l2);
	}

}

class Point {
	public int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point other) {
		new Point(other.x, other.y);
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}

class Line {
	public Point start, end;

	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	public Line deepCopy() {
		return new Line(new Point(this.start.x, this.start.y), new Point(this.end.x, this.end.y));
	}

	@Override
	public String toString() {
		return "Line [start=" + start + ", end=" + end + "]";
	}

}
