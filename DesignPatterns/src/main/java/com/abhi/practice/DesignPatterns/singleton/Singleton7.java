package com.abhi.practice.DesignPatterns.singleton;

import java.util.HashMap;

//Multiton with lazy loading
public class Singleton7 {

	public static void main(String[] args) {
		Printer primary = Printer.getPrinter(Subsystem.PRIMARY);
		Printer aux = Printer.getPrinter(Subsystem.AUXILIARY);
		Printer fallback = Printer.getPrinter(Subsystem.FALLBACK);
		
		Printer primary2 = Printer.getPrinter(Subsystem.PRIMARY);
	}
}


enum Subsystem{
	PRIMARY,
	AUXILIARY,
	FALLBACK
}

class Printer{
	
	private static int count = 0;
	private Printer() {
		count++;
		System.out.println("A total of "+count+" intances are created so far.");
	}
	
	private static HashMap<Subsystem, Printer> instances = new HashMap<>();
	
	public static Printer getPrinter(Subsystem ss) {
		if(instances.containsKey(ss)) {
			return instances.get(ss);
		}
		Printer instance = new Printer();
		instances.put(ss, instance);
		return instance;
	}
}
