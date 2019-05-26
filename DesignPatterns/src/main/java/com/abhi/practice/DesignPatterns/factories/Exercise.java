package com.abhi.practice.DesignPatterns.factories;

public class Exercise {
	public static void main(String[] args) {
		PersonFactory factory = new PersonFactory();
		Person p1 = factory.createPerosn("person 0");
		Person p2 = factory.createPerosn("person 1");

		System.out.println(p1);
		System.out.println(p2);;
	}

}

class Person {

	public int id;
	public String name;

	public Person(int id, String name) {
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
	
}


class PersonFactory{
	
	private static int personIdCount = 0;
	public Person createPerosn(String name){
		return new Person(personIdCount++, name);
	}
	
}