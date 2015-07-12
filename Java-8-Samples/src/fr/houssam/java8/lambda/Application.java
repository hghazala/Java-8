package fr.houssam.java8.lambda;


import java.util.ArrayList;
import java.util.List;

import fr.houssam.java8.entity.Person;
import fr.houssam.java8.service.ArithmeticOperationsService;
import fr.houssam.java8.service.PersonService;

public class Application {

	public static void main(String[] args) {
		ArithmeticOperationsService addition = (int x, int y) -> {return (x + y);};
		System.out.println(addition.uneOperation(4, 5));
		
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person(1, "HAHA", "GAGAGA", 29);
		Person p2 = new Person(1, "GGGGA", "SISISI", 9);
		persons.add(p1);
		persons.add(p2);
		
		PersonService ps = new PersonService();
		ps.getPersonWithAgeGreaterThan10(persons);
	}

}
