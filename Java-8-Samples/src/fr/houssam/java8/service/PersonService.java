package fr.houssam.java8.service;

import java.util.List;
import java.util.Optional;
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
}
