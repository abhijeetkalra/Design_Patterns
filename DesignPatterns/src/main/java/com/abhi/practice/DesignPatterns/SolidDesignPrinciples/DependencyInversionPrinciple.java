package com.abhi.practice.DesignPatterns.SolidDesignPrinciples;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.javatuples.Triplet;

public class DependencyInversionPrinciple {

	public static void main(String[] args) {
		Person john = new Person("John");
		Person chris = new Person("Chris");
		Person matt = new Person("Matt");
		
		Relationships relationships = new Relationships();
		relationships.addParentAndChild(john, chris);
		relationships.addParentAndChild(john, matt);
		
		new Research(relationships);
		
	}
}


//Modeling Relationship b/w people


enum Relation{
	PARENT,
	CHILD,
	SIBLING
}

class Person{
	
	public String name;
	
	public Person(String name) {
		this.name = name;
	}
}

class Relationships implements RelationshipBrowser{ // low level module sine related to DB, no business logic , not imp to end-user
	private List<Triplet<Person, Relation, Person>> relations = new ArrayList<>();
	
	
	public List<Triplet<Person, Relation, Person>> getRelations() {
		return relations;
	}


	public void addParentAndChild(Person parent, Person child) {
		relations.add(new Triplet<>(parent, Relation.PARENT, child));
		relations.add(new Triplet<>(child, Relation.CHILD, parent));
	}


	@Override
	public List<Person> findAllChildrenOf(String name) {
		return relations.stream()
				.filter(x -> Objects.equals(x.getValue0().name, name)
						&& x.getValue1() == Relation.PARENT)
				.map(Triplet::getValue2)
				.collect(Collectors.toList());
				
	}
}


class Research{ //high-level, imp for end user 
	//here high-level is dependent on low-level since Relationships is used in Research constructor
	/*public Research(Relationships relationships) {
		List<Triplet<Person, Relation, Person>> relations = relationships.getRelations();
		relations.stream().filter(x -> x.getValue0().name.equals("John")
				&& x.getValue1() == Relation.PARENT)
		.forEach(ch -> System.out.println(
				"John has a child called " + ch.getValue2().name
				));
	}*/
	
	//depending on Abstraction
	public Research(RelationshipBrowser browser) {
		List<Person> children = browser.findAllChildrenOf("John");
		children.forEach(ch -> System.out.println("Abstracted: John has child called "+ch.name));
	}
}


//introducing abstraction, to implemented on low=level module
interface RelationshipBrowser{
	List<Person> findAllChildrenOf(String name);
}