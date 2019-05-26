package com.abhi.practice.DesignPatterns.prototype;
/*package com.abhi.practice.DesignPatterns.prototype;

import java.util.Arrays;


//Implmentation of CLone

// Not recommended for deep copying, default behavior of clone to make shallow copy, better to use other mechanism
public class prototype1 {
	
	public static void main(String[] args) throws Exception{
		Person person1 = new Person(new String[] {"John", "Smith"}, new Address("London Street", 123));
		
		//The approuch of cloning is bad, since both the objects are referring to same;
		Person person2 = (Person) person1.clone();
		person2.names[0] = "Jane";
		person2.address.houseNumber = 124;
		
		System.out.println(person1);
		System.out.println(person2);
	}

}

class Address implements Cloneable{
	public String streetname;
	public int houseNumber;
	public Address(String streetname, int houseNumber) {
		super();
		this.streetname = streetname;
		this.houseNumber = houseNumber;
	}
	
	@Override
	public String toString() {
		return "Address [streetname=" + streetname + ", houseNumber=" + houseNumber + "]";
	}
	
	//deep copy
	public Object clone() throws CloneNotSupportedException {
		return new Address(streetname, houseNumber);
	}
	
}

class Person implements Cloneable{
	public String [] names;
	public Address address;
	public Person(String[] names, Address address) {
		super();
		this.names = names;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [names=" + Arrays.toString(names) + ", address=" + address + "]";
	}
	
	public Object clone() throws CloneNotSupportedException{
		return new Person(names.clone(), (Address) address.clone());
	}
	
	
}
*/