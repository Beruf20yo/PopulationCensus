import enums.Education;
import enums.Sex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class MethodsForPersonTest {
    static List<Person> persons = new ArrayList<>();
    static MethodsForPerson methods;
    @BeforeAll
    static void createPersons(){
        persons.add(new Person("Karalina","Engels",16, Sex.WOMAN, Education.ELEMENTARY));
        persons.add(new Person("Nix","Shved",12, Sex.MAN, Education.ELEMENTARY));
        persons.add(new Person("Nina","Kotor",9, Sex.WOMAN, Education.ELEMENTARY));

        persons.add(new Person("Alex","Gorski",18, Sex.MAN, Education.SECONDARY));
        persons.add(new Person("Uroi","Klimov",23, Sex.MAN, Education.HIGHER));
        persons.add(new Person("Nik","Voichich",25, Sex.MAN, Education.HIGHER));
        persons.add(new Person("Jack","Potroshitel",26, Sex.MAN, Education.HIGHER));

        persons.add(new Person("Nadya","Smith",29, Sex.WOMAN, Education.HIGHER));
        persons.add(new Person("Cira","Young",45, Sex.WOMAN, Education.HIGHER));
        persons.add(new Person("Eren","Yager",67, Sex.MAN, Education.HIGHER));
        methods = new MethodsForPerson(persons);
    }
//JUnit tests
    @Test
    void getTeenagersCountTest(){
        Assertions.assertEquals(3L,methods.getTeenagers());
    }
    @Test
    void getConscriptsCountTest(){
        Assertions.assertEquals(4, methods.getConscripts().size());
    }
    @Test
    void getWorkableCountPersons(){
        Assertions.assertEquals(5,methods.getWorkablePersons().size());
    }
    //Hamcrest tests
    @Test
    void getWorkablePersons(){
        assertThat(methods.getWorkablePersons(),
                not(containsInAnyOrder(new Person("Eren","Yager",67, Sex.MAN, Education.HIGHER))));
    }
    @Test
    void getConscriptsTest(){
        assertThat(methods.getConscripts(), hasItem("Klimov"));
    }
}
