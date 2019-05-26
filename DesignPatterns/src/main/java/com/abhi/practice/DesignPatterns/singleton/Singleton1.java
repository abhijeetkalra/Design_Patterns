package com.abhi.practice.DesignPatterns.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Singleton1 {

	static void saveToFile(BasicSingleton basicSingleton, String fileName) throws Exception {
		try(FileOutputStream fileOut = new FileOutputStream(fileName);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);){
			out.writeObject(basicSingleton);
		}
	}
	
	static BasicSingleton readFromFile(String fileName) throws Exception{
		try(FileInputStream fileIn = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(fileIn);){
			return (BasicSingleton) in.readObject();
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		BasicSingleton basicSingleton = BasicSingleton.getInstance();
		basicSingleton.setValue(111);
		saveToFile(basicSingleton, "singleton.bin");
		basicSingleton.setValue(222);
		
		BasicSingleton basicSingleton2 = readFromFile("singleton.bin");
		System.out.println(basicSingleton.getValue());
		System.out.println(basicSingleton2.getValue());
	}

}

// 2 Problems with this approach
// 1. Reflection-Using reflection, the private constructors can be called easily
// 2. Serialization-When we deserialize, and agains serializa back the JVM doesnt care about the private constructor, it would create the object
class BasicSingleton implements Serializable{
	
	private int value = 0;
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private BasicSingleton() {};
	
	private static final BasicSingleton INSTANCE = new BasicSingleton();
	
	public static BasicSingleton getInstance() {
		return INSTANCE;
	}
	
	//Purpose:Giving JVM a hint, whenever a serialization happens, it has to happen in the context of this instance
	protected Object readResolve() {
		return INSTANCE;
	}
}
