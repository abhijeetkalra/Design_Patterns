package com.abhi.practice.DesignPatterns.singleton;


//Inner class Singleton
public class Singleton4 {

}

//This approach is thread safe
class InnerStaticSingleton{
	private InnerStaticSingleton() {}
	
	private static class Impl{
		private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
	} 
	
	public static InnerStaticSingleton getInstance() {
		return Impl.INSTANCE;
	}
}
