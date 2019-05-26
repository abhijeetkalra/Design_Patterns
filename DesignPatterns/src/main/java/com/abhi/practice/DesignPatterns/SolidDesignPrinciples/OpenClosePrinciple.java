package com.abhi.practice.DesignPatterns.SolidDesignPrinciples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//Open for Extension, closed for Modification

public class OpenClosePrinciple {
	//Implementing Filter for e-commerce say Amazon
	
	public static void main(String[] args) {
		Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
		Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
		Product house = new Product("House", Color.BLUE, Size.LARGE);
		List<Product> products = new ArrayList<>();
		products.add(apple);
		products.add(tree);
		products.add(house);
		
		ProductFilter filterOld = new ProductFilter();
		System.out.println("Green Products (Old) : ");
		filterOld.filterByColor(products, Color.GREEN).
		forEach(p -> System.out.println(" - "+ p.name + " is green"));
		
		
		BetterFilter betterFilter = new BetterFilter();
		System.out.println("Green Products (BetterFilter) : ");
		betterFilter.filter(products, new ColorSpecification(Color.GREEN)).
		forEach(p -> System.out.println(" - "+ p.name + " is green"));
		
		System.out.println("Blue and Large Products (BetterFilter) : ");
		betterFilter.filter(products, new ColorandSizeSpecification(Color.BLUE, Size.LARGE))
		.forEach(p -> System.out.println(" - " + p.name + " is large and blue"));
		
		
		System.out.println("Blue and Large Products (BetterFilter) AndSpecification : ");
		betterFilter.filter(products, new AndSpecification<>(new ColorSpecification(Color.BLUE), new SizeSpecification(Size.LARGE)))
		.forEach(p -> System.out.println(" - " + p.name + " is large and blue"));
		
	} 
}

enum Color{
	RED, GREEN, BLUE
}

enum Size {
	SMALL, MEDIUM, LARGE, HUGE
}

class Product{
	public String name;
	public Color color;
	public Size size;
	
	public Product(String name, Color color, Size size) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
	}
}


//This approach is Ok for(say 2 parameters), if parameters increases then lot of work required. 
class ProductFilter{
	
	public Stream<Product> filterByColor(List<Product> products, Color color){
		return products.stream().filter(p -> p.color == color);
	}
	
	public Stream<Product> filterBySize(List<Product> products, Size size){
		return products.stream().filter(p -> p.size == size);
	}
	
	public Stream<Product> filterBySizeAndColor(List<Product> products, Size size, Color color){
		return products.stream().filter(p -> p.size == size && p.color == color);
	}
	
}



//New and Better Generic Approach
/*Now for implementing new Filter if more parameters are introduced, we don't have to to existing classes, 
we can just introduce new classes implementing the interfaces*/

interface Specification<T>{
	boolean isSatisfied(T item);
}

interface Filter<T>{
	Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpecification implements Specification<Product>{
	
	private Color color;

	public ColorSpecification(Color color) {
		this.color = color;
	}

	@Override
	public boolean isSatisfied(Product item) {
		return item.color == color;
	}
	
}

//for filter with more than 1 parameters
class ColorandSizeSpecification implements Specification<Product>{
	
	private Color color;
	private Size size;

	public ColorandSizeSpecification(Color color, Size size) {
		super();
		this.color = color;
		this.size = size;
	}

	@Override
	public boolean isSatisfied(Product item) {
		return item.color == color && item.size == size;
	}
	
}

class AndSpecification<T> implements Specification<T>{
	
	private Specification<T> first, second;
	
	public AndSpecification(Specification<T> first, Specification<T> second) {
		super();
		this.first = first;
		this.second = second;
	}
	@Override
	public boolean isSatisfied(T item) {
		return first.isSatisfied(item) && second.isSatisfied(item);
	}
	
}

class SizeSpecification implements Specification<Product>{
	
	private Size size;

	public SizeSpecification(Size size) {
		this.size = size;
	}

	@Override
	public boolean isSatisfied(Product item) {
		return item.size == size;
	}
	
}


class BetterFilter implements Filter<Product>{

	@Override
	public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
		return items.stream().filter(p -> spec.isSatisfied(p));
	}
	
}

