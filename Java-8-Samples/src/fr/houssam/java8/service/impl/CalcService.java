package fr.houssam.java8.service.impl;

import fr.houssam.java8.service.ICalcService;

public class CalcService {

	public static void main(String[] args) {
		ICalcService calcService = new ICalcService() {

			@Override
			public void calc(int a, int b) {
				System.out.println("a + b = " + (a+b));
			}
		};
		calcService.calc(5, 6);

		ICalcService calcService2 = (a, b) -> {
			System.out.println("with lambda expression a - b = " + (a - b));
		};
		calcService2.calc(20, 6);
		calcService2.puissance(5);
	}

}
