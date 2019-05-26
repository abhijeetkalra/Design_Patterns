package com.abhi.practice.DesignPatterns.builder;

//Faceted Builder(Multiple Builders)
public class Builder3 {

	public static void main(String[] args) {
		PersonBuilder pb = new PersonBuilder();
		Person person = pb
				.lives()
				.at("Some Street")
				.in("Some City")
				.withPostcode("Some Poscode")
			.works()
				.at("Some Company")
				.asA("stm")
				.earning(12324).build();
		
		System.out.println(person);
	}
}

//Diff builder for address and employment
class Person{
	//address
	public String streetAddress, postcode, city;
	//emploment
	public String companyName, position;
	public int anualIncome;
	@Override
	public String toString() {
		return "Person [streetAddress=" + streetAddress + ", postcode=" + postcode + ", city=" + city + ", companyName="
				+ companyName + ", position=" + position + ", anualIncome=" + anualIncome + "]";
	}
}


//builder facade
class PersonBuilder{
	protected Person person = new Person();
	
	public PersonAddressBuilder lives() {
		return new PersonAddressBuilder(person);
	}
	
	public PersonJobBuilder works() {
		return new PersonJobBuilder(person);
	}
	
	public Person build() {
		return person;
	}
}

class PersonAddressBuilder extends PersonBuilder{
	public PersonAddressBuilder(Person person) {
		this.person = person;
	}
	
	public PersonAddressBuilder at(String streetAddress) {
		person.streetAddress = streetAddress;
		return this;
	}
	
	public PersonAddressBuilder withPostcode(String postcode) {
		person.postcode = postcode;
		return this;
	}
	
	public PersonAddressBuilder in(String city) {
		person.city = city;
		return this;
	}
}

class PersonJobBuilder extends PersonBuilder{
	public PersonJobBuilder(Person person) {
		this.person = person;
	}
	
	public PersonJobBuilder at(String companyName) {
		person.companyName = companyName;
		return this;
	}
	
	public PersonJobBuilder asA(String position) {
		person.position = position;
		return this;
	}
	
	public PersonJobBuilder earning(int anualIncome) {
		person.anualIncome = anualIncome;
		return this;
	}
}