package fr.houssam.java8.service;

public class CalcService {

	public static void main(String[] args) {
		ICalcService calcService = new ICalcService() {
			@Override
			public void calc(int a, int b) {
				System.out.println("a + b = "+(a+b));
				
			}
		};
		calcService.calc(1, 6);
		
		//Implementation using lambda expression
		ICalcService calcService2 = (a, b)->{System.out.println("with lambda : a + b = "+(a+b));};
		calcService2.calc(35, 20);
	}
}
