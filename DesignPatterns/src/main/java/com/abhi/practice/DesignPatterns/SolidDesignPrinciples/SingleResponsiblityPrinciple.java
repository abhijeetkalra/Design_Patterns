package com.abhi.practice.DesignPatterns.SolidDesignPrinciples;

import java.util.ArrayList;
import java.util.List;

public class SingleResponsiblityPrinciple {
    //Single Class should have one primary responsibility
	
	public static void main(String[] args) {
		Journel journel = new Journel();
		journel.addEntry("Hello World");
		journel.addEntry("Hey I am doing this course");
		System.out.println(journel);
	}
}


//This class is only meant to add/ remove entries, persistence should be a different concern
class Journel{
	private final List<String> entries = new ArrayList<String>();
	private static int count = 0;
	
	public void addEntry(String text) {
		entries.add("" + (++count) + ": " + text);
	}
	
	public void removeEntry(int index) {
		entries.remove(index);
	}
	
	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}
	
	//breaking Single responsibility Principle 
	// This class is only meant to add/ remove entries, persistence should be a different concern 
	// A new persistence class should be defined for these functionalities
	public void save(String filename) {
		/*try (PrintStream stream = new PrintStream(filename))
		{
			out.println(toString());
		}*/
	}
	
}


