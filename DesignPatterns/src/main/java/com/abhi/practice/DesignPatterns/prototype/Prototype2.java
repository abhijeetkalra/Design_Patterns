package com.abhi.practice.DesignPatterns.prototype;


//Copy Constructor
public class Prototype2 {

	public static void main(String[] args) {
		Person p1 = new Person("John", new Address("Gali No 420", 123));
		Person p2 = new Person(p1);
		p2.name = "Chris";
		p2.address.houseNumber = 124;
		
		System.out.println(p1);
		System.out.println(p2);
	}
}

class Address{
	public String streetname;
	public int houseNumber;
	
	public Address(String streetname, int houseNumber) {
		super();
		this.streetname = streetname;
		this.houseNumber = houseNumber;
	}
	
	//Copy Constructor
	public Address(Address other) {
		this(other.streetname, other.houseNumber);
	}
	
	@Override
	public String toString() {
		return "Address [streetname=" + streetname + ", houseNumber=" + houseNumber + "]";
	}
}


class Person{
	public String  name;
	public Address address;
	public Person(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	
	public Person (Person other) {
		this(other.name, new Address(other.address));
	}
	
	@Override
	public String toString() {
		return "Person [name=" +name + ", address=" + address + "]";
	}
	

	
	
}
