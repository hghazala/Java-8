package fr.houssam.java8.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import fr.houssam.java8.entity.Person;

public class PersonService {

	public List<Person> getPersonWithAgeGreaterThan10(List<Person> persons){
		return persons
				.stream()
				.filter(person -> person.getAge() > 10)
				.collect(Collectors.toList());
	}
	
	public int getPersonAgesSum(List<Person> persons){
		return persons
				.stream()
				.mapToInt(Person::getAge)
				.distinct()
				.sum();
	}
	
	public void printPersonWithAgeGreaterThan10(List<Person> persons){
		persons.forEach(
						 person -> System.out.println(person.getNom())
					   );
	}
	
	public Optional<Person> fromPersonsById(int id, List<Person> persons){
		return persons.stream()
					  .filter(person -> person.getId() == id)
					  .findFirst();
	}
	
	public Map<String,Long> countByActivity(List<Person> persons){
		return persons.stream()
				.flatMap(p->p.getActivite().stream())
		        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
	
	public List<Person> getByActivity(List<Person> persons, String activite){
		List<Person> personsResult = new ArrayList<Person>(); 
		persons.stream()
				.forEach(
						  p->{
							  //p.getActivite().stream().filter(s->activite.equals(s)).collect(Collectors.toList());
							   for (String act: p.getActivite()) {
								   
								  if(activite.equals(act)){
									 personsResult.add(p);
								  }
							   }
						     }
						);
		return personsResult;
	}
}
