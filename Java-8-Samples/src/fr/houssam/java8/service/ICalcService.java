package fr.houssam.java8.service;

@FunctionalInterface
public interface ICalcService {
	
	void calc(int a, int b);
	
	default void puissance(int a){
		System.out.println("a * a = "+ a * a);
	}
}
