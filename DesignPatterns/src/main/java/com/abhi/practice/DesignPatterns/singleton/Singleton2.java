package com.abhi.practice.DesignPatterns.singleton;

//Static Block Singleton : If the constructor may throw any Exception, use static block to instantiate objrct
public class Singleton2 {

}

class StaticBlockSingleton{
	
	private StaticBlockSingleton() throws Exception {
		System.out.println("Singleton is intializing");
		throw new Exception("Delibrately Throwing"); 
	}
	
	private static StaticBlockSingleton instance;
	
	static {
		try {
			instance = new StaticBlockSingleton();
		}
		catch (Exception e) {
			System.err.println("Failed to create instance");
		}
	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}

	public static void setInstance(StaticBlockSingleton instance) {
		StaticBlockSingleton.instance = instance;
	}
	
	
}
