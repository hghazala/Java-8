package fr.houssam.java8.run;


import com.google.common.collect.Lists;
import fr.houssam.java8.entity.Person;
import fr.houssam.java8.service.IArithmeticOperationsService;
import fr.houssam.java8.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.logging.Logger;

public class Application {

    private static Logger logger = Logger.getLogger(Application.class.getName());

    public static void getName() {
        throw new RuntimeException();
    }

    public static void main(String[] args) throws Exception {
        IArithmeticOperationsService operationImplementation = (int x, int y) -> x + y;
        System.out.println(operationImplementation.abstractOperation(4, 5));

        List<Person> persons;
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

        Person p1 = Person.builder()
                .id(1)
                .nom("Houssam")
                .prenom("GHAZALA")
                .age(29)
                .activite(activite1).build();
        Person p2 = Person.builder()
                .id(2)
                .nom("GGGGA")
                .prenom("SISISI")
                .age(56)
                .activite(activite2).build();
        Person p3 = Person.builder()
                .id(3)
                .nom("KKKK")
                .prenom("BBBBB")
                .age(45).
                        activite(activite3).build();
        Person p4 = Person.builder()
                .id(4)
                .nom("SSSS")
                .prenom("FFFFF")
                .age(36)
                .activite(activite4).build();

        persons = Lists.newArrayList(p1, p2, p3, p4);

        PersonService ps = new PersonService();
        ps.getPersonWithAgeGreaterThan10(persons);
        ps.countByActivity(persons).entrySet().toArray();

        ps.getByActivity(persons, "pagisteTTT")
                .stream()
                .forEach(p -> System.out.println(p.toString()));

        //Optional de java 8 nous permet d'avoir un objet null
        //Je demande une personne avec un id 0, absent
        //dans la liste persons.
        Optional<Person> objetNull = ps.fromPersonsByIdFacon1(0, persons);

        if (objetNull.isPresent()) {
            logger.info("fetch person id : " + objetNull.get().getNom());
        } else {
            logger.info("person absent");
        }

        ps.supplier();
        Person person = Person.builder().id(1).nom("Foo").prenom("Bar").build();
        ps.doSomething(() -> person,
                t -> System.out.println(t),
                t -> System.out.println("Error"));

        //Invoke a lambda
        Function<String, String> lambda = (String param) -> "Hello " + param;
        String sayHelloTo = lambda.apply("Houssam");
        System.out.println("sayHelloTo: " + sayHelloTo);

        //Composing functions i java
        BiFunction<Integer, Integer, Integer> multiplication = (a, b) -> a * b;
        Function<Integer, Integer> ajoute1000 = (input) -> input + 1000;
        Function<Integer, Integer> foisDeux = (input) -> input * 2;

        boolean shouldBeEqualTo2000 = multiplication
                .andThen(ajoute1000)
                .apply(10, 100)
                .equals(2000);
        boolean shouldBeEqualTo3000 = ajoute1000
                .compose(foisDeux)
                .apply(1000)
                .equals(3000);

        System.out.println("shouldBeEqualTo2000 : " + shouldBeEqualTo2000);
        System.out.println("shouldBeEqualTo3000 : " + shouldBeEqualTo3000);
    }
}
