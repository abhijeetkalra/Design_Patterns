package com.abhi.practice.DesignPatterns.SolidDesignPrinciples;

public class InterfaceSegregationPrinciple {

}


class Document{
	
}

//Here Machine interface has all the functionalities, class implementing this has to implement all of it.
// Hence for a good approach, all the functionalities should be a separate interface.
interface Machine{
	void print(Document d);
	void fax(Document d);
	void scan(Document d);
}


class MultiFuntionPrinter implements Machine{

	@Override
	public void print(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fax(Document d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scan(Document d) {
		// TODO Auto-generated method stub
		
	}
	
}

//YAGNI - You ain't going to need it

interface Printer{
	void print(Document d);
}

interface Scanner{
	void scan(Document d);
}

//if more funtionalities are required
interface MultiFuntionalDevice extends Printer, Scanner {}


//for better approach use decorator pattern 
class MultiFuncMachine implements MultiFuntionalDevice{
	
	private Printer printer;
	private Scanner scanner;

	
	public MultiFuncMachine(Printer printer, Scanner scanner) {
		this.printer = printer;
		this.scanner = scanner;
	}

	@Override
	public void print(Document d) {
		printer.print(d);
		
	}

	@Override
	public void scan(Document d) {
		scanner.scan(d);
	}
	
}