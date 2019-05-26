package com.abhi.practice.DesignPatterns.singleton;

//Enum Based Singleton: Can define the INSTANCE in enum as a single member, but other variable are serializable.
public class Singleton5 {

}

enum EnumBasedSingleton{
	INSTANCE;
	
	private EnumBasedSingleton() {
		value = 42;
	}
	
	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
