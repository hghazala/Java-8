package fr.houssam.java8.run;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import fr.houssam.java8.entity.Person;
import fr.houssam.java8.service.IArithmeticOperationsService;
import fr.houssam.java8.service.PersonService;

public class Application {
	
	private static Logger logger = Logger.getLogger(Application.class.getName());
	
	public static void main(String[] args) {
		IArithmeticOperationsService addition = (int x, int y) -> {return (x + y);};
		System.out.println(addition.uneOperation(4, 5));
		
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person(1, "HAHA", "GAGAGA", 29);
		Person p2 = new Person(2, "GGGGA", "SISISI", 9);
		persons.add(p1);
		persons.add(p2);
		
		PersonService ps = new PersonService();
		ps.getPersonWithAgeGreaterThan10(persons);
		
		//Optional de java 8 nous permet d'avoir un objet null
		//Je demande une personne avec un id 0, absent
		//dans la liste persons.
		Optional<Person> objetNull = ps.fromPersonsById(0, persons);
		
		if(objetNull.isPresent()){
			logger.info("fetch person id : "+objetNull.get().getNom());
		}else{
			logger.info("person absent");
		}
	}
}
