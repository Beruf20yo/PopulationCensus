import enums.Education;
import enums.Sex;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
public class MethodsForPerson {
    private List<Person> people;

    //Возвращает кол-во несовершеннолетних
    public long getTeenagers(){
        return people.stream().filter(x -> x.getAge() < 18).count();
    }

    //Возвращает список фамилий призывников от 18 до 27
    public List<String> getConscripts(){
        return people.stream().filter(x -> x.getSex().equals(Sex.MAN) && x.getAge() < 27 && x.getAge() >= 18)
                .map(Person::getFamily).collect(Collectors.toList());
    }

    /*Возвращает  отсортированный по фамилии список потенциально работоспособных людей с высшим образованием в выборке
     (т.е. людей с высшим образованием от 18 до 60 лет для женщин и до 65 лет для мужчин)
     */
    public List<Person> getWorkablePersons(){
        return people.stream().filter(x-> x.getEducation().equals(Education.HIGHER))
                .filter(x -> x.getAge() >= 18)
                .filter(x -> (x.getSex() == Sex.MAN ? x.getAge() < 65 : x.getAge() < 60))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
    }
}
