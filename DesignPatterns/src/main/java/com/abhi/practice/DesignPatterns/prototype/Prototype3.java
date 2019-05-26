package com.abhi.practice.DesignPatterns.prototype;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

//Using Serialization 
public class Prototype3 {
  
	public static void main(String[] args) {
		Foo obj = new Foo(23, "Stm");
		Foo obj2 = SerializationUtils.roundtrip(obj);
		obj2.whatever = "New FOO";
		System.out.println(obj);
		System.out.println(obj2);
	}
}


class Foo implements Serializable{
	public int stuff;
	public String whatever;
	
	public Foo(int stuff, String whatever) {
		super();
		this.stuff = stuff;
		this.whatever = whatever;
	}

	@Override
	public String toString() {
		return "Foo [stuff=" + stuff + ", whatever=" + whatever + "]";
	}	
	
}
