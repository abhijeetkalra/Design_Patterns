package com.abhi.practice.DesignPatterns.SolidDesignPrinciples;

//You should be able to substitute a sub class to a base class
public class LiskovSubstitutionPrinciple {
	
	static void useIt(Rectangle r) {
		int width = (int) r.getWidth();
		r.setHeight(10);
		//area = width * 10;
		System.out.println(
				"Expected area of " + (width * 10 ) + 
				", got " + r.getArea()
				);
	}
	
	public static void main(String[] args) {
		Rectangle rc = new Rectangle(2, 3);
		useIt(rc);
		
		//this will end up in error since we have violated Liskov Substitution Principle
		Rectangle sq = new Square();
		sq.setWidth(5);
		useIt(sq);
	}
}


//Use Factory design Pattern for Good Approach
class RectangleFactory{
	public static Rectangle newRectangle(int width, int height) {
		return new Rectangle(width, height);
	}
	
	public static Rectangle newSquare(int size) {
		return new Rectangle(size, size);
	}
}

class Rectangle{
	
	protected int width, height;
	
	public Rectangle() {}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	
	public int getArea() {
		return width*height;
	}
}


class Square extends Rectangle{
	public Square() {}
	
	public Square (int size) {
		width = height = size;
	}
	
	//@Override
	public void setWidth(int width) {
		super.width = width;
		super.height = width;
	}
	
	//@Override
	public void setHeight(int height) {
		this.height = height;
		super.width = height;
	}
}
