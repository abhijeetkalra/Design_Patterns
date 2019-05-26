package com.abhi.practice.DesignPatterns.builder;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
	
	public static void main(String[] args) {
		CodeBuilder cb = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
		System.out.println(cb);
	}
	
}


class Field{
	public String name, type;

	public Field(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String toString() {
		return String.format("   public %s %s;\n", type, name); 
	}
	
}

class Code{
	
	public String className;
	
	
	public Code(String className) {
		this.className = className;
	}

	List<Field> fields = new ArrayList<>();
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("public class ")
		.append(className).append("\n{\n");
		fields.forEach(field -> sb.append(field));
		sb.append("}");
		return sb.toString();
	}	
}


class CodeBuilder{
	
	
	public Code code;
	
	public CodeBuilder(String className) {
		this.code = new Code(className);
	}
	
	public CodeBuilder addField(String name, String type) {
		code.fields.add(new Field(name, type));
		return this;
	}
	
	public String toString() {
		return code.toString();
	}

}