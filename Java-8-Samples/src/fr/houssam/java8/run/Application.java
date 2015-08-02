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
		List<String> activite1 = new ArrayList<String>();
		activite1.add("journaliste");
		activite1.add("pagiste");
		
		List<String> activite2 = new ArrayList<String>();
		activite2.add("journaliste");
		activite2.add("pagisteTTT");
		
		List<String> activite3 = new ArrayList<String>();
		activite3.add("redacteur");
		activite3.add("toto");
		
		List<String> activite4 = new ArrayList<String>();
		activite4.add("directeur");
		activite4.add("pagisteTTT");
		
		Person p1 = Person
						.builder()
						.id(1)
						.nom("Houssam")
						.prenom("GHAZALA")
						.age(29)
						.activite(activite1).build();
		Person p2 = Person
						.builder()
						.id(2)
						.nom("GGGGA")
						.prenom("SISISI")
						.age(56)
						.activite(activite2)
						.build();
		Person p3 = Person
						.builder()
						.id(3)
						.nom("KKKK")
						.prenom("BBBBB")
						.age(45).
						activite(activite3)
						.build();
		Person p4 = Person
						.builder()
						.id(4)
						.nom("SSSS")
						.prenom("FFFFF")
						.age(36)
						.activite(activite4)
						.build();
		
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		persons.add(p4);
		
		PersonService ps = new PersonService();
		ps.getPersonWithAgeGreaterThan10(persons);
		ps.countByActivity(persons).entrySet().toArray();
		
		ps.getByActivity(persons, "pagisteTTT")
		  .stream()
		  .forEach(p->System.out.println(p.toString()));
		
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
