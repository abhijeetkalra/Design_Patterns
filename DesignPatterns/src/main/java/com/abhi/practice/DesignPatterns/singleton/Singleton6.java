package com.abhi.practice.DesignPatterns.singleton;


//Monostate Singleton
public class Singleton6 {

	public static void main(String[] args) {
		ChiefExecutiveOfficer ceo = new ChiefExecutiveOfficer();
		ceo.setAge(25);
		ceo.setName("Some Name");
		
		//CEO2 is already initialized
		ChiefExecutiveOfficer ceo2 = new ChiefExecutiveOfficer();
		System.out.println(ceo2);
	}
}

//if you want to make this class as singleton, just make the instance variable as static(Not Recommended, no clear info)
class ChiefExecutiveOfficer{
	private static String name;
	private static int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		ChiefExecutiveOfficer.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		ChiefExecutiveOfficer.age = age;
	}
	
	@Override
	public String toString() {
		return "ChiefExecutiveOfficer [name=" + name + ", age=" + age + "]";
	}
}
