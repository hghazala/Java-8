package fr.houssam.java8.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import fr.houssam.java8.entity.Person;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

	@Spy
	private PersonService personService;
	private List<Person> persons;
	
	@Before
	public void init_test(){
		List<String> activite1 = Lists.newArrayList("journaliste", "pigiste");
		List<String> activite2 = Lists.newArrayList("journaliste", "pigisteTTT");
		List<String> activite3 = Lists.newArrayList("redacteur", "toto");
		List<String> activite4 = Lists.newArrayList("directeur", "pigisteTTT");

		Person p1 = Person.builder().id(1)
				.nom("Houssam")
				.prenom("GHAZALA")
				.age(29)
				.activite(activite1).build();
		Person p2 = Person.builder().id(2)
				.nom("GGGGA")
				.prenom("SISISI")
				.age(56)
				.activite(activite2).build();
		Person p3 = Person.builder().id(3)
				.nom("KKKK")
				.prenom("BBBBB")
				.age(45).
				activite(activite3).build();
		Person p4 = Person.builder().id(4)
				.nom("SSSS")
				.prenom("FFFFF")
				.age(45)
				.activite(activite4).build();

		persons = Lists.newArrayList(p1, p2, p3, p4);
	}
	
	@Test
	public void testName() throws Exception {
		List<String> allActivities = personService.getAllActivities(persons);
		
		Assertions.assertThat(allActivities).hasSize(8);
		//[toto=1, pigisteTTT=2, directeur=1, pigiste=1, redacteur=1, journaliste=2]
	}
	
	@Test
	public void distinct_count() throws Exception {
		long count = personService.countAges(persons);
		
		Assertions.assertThat(count).isEqualTo(3);
	}
	
	@Test
	public void test_peek() throws Exception {
		List<Person> moreThan45 = personService.peek(persons);
		
		Assertions.assertThat(moreThan45).hasSize(3);
		Assertions.assertThat(moreThan45).extracting("nom").containsExactly("GGGGA","KKKK","SSSS");
	}
}
