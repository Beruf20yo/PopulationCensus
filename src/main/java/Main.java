import enums.Education;
import enums.Sex;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        WorkWithPerson workWithPerson = new WorkWithPerson();
        workWithPerson.setPeople(makePersons());
        System.out.println("Количество людей меньше 18 лет: \n"
                + workWithPerson.getTeenagers());
        System.out.println("Фамилии призывников: ");
        for(var cons: workWithPerson.getConscripts()){
            System.out.println(cons);
        }
        System.out.println("Работоспособные люди: ");
        for(var person : workWithPerson.getWorkablePersons()){
            System.out.println(person.toString());
        }
    }
    public static List<Person> makePersons(){
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        return persons;
    }
}
