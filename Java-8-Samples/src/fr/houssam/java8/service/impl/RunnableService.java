package fr.houssam.java8.service.impl;

public class RunnableService {

	public static void main(String[] args) {
		Runnable thread = ()->{System.out.println("in thread");};
		thread.run();
	}
}
