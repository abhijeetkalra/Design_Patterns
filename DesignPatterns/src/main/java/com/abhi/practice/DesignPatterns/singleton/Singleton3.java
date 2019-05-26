package com.abhi.practice.DesignPatterns.singleton;

public class Singleton3 {

}

// Thread Safety
class LazySingeton {
	private static LazySingeton instance;

	private LazySingeton() {
		System.out.println("Initializing lazy singleton");
	}

	// To make instantiation of object thread safe, we can use synchronized method
	// signature
	public static synchronized LazySingeton getInstance1() {
		if (instance == null) {
			instance = new LazySingeton();
		}
		return instance;
	}

	// double-checked locking (Obsolete approach)
	public static LazySingeton getInstance2() {
		if (instance == null) {
			synchronized (LazySingeton.class) {
				if (instance == null) {
					instance = new LazySingeton();
				}
			}
		}
		return instance;
	}
}