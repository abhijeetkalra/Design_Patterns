/*package com.abhi.practice.DesignPatterns.builder;


//Fluent Builder Inheritance with Recursive Generics
public class Builder2 {
	public static void main(String[] args) {
		PersonBuilder pb = new PersonBuilder();
		Person person1= pb.withName("Cool Guy").build();
		System.out.println(person1);
		
		EmployeeBuilder eb = new EmployeeBuilder();
		Person person2 = eb.withName("ABC").worksAt("XYZ").build();
		System.out.println(person2);
	}
}


class Person {
	public String name;
	public String position;
	@Override
	public String toString() {
		return "Person [name=" + name + ", position=" + position + "]";
	}	
}

class PersonBuilder<SELF extends PersonBuilder<SELF>>{
	
	protected Person person = new Person();
	
	public SELF withName(String name) {
		person.name = name;
		return self();
	}
	
	public Person build() {
		return person;
	}
	
	protected SELF self() {
		return (SELF) this;
	}
}


class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{
	public EmployeeBuilder worksAt(String position) {
		person.position = position;
		return self();
	}
	
	
	public EmployeeBuilder self() {
		return this;
	}
}*/