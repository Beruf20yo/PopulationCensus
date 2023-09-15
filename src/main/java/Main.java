public class Main {
    public static void main(String[] args) {
        WorkWithPerson workWithPerson = new WorkWithPerson();
        MethodsForPerson methodsForPerson = new MethodsForPerson(workWithPerson.makePersons());
        System.out.println("Количество людей меньше 18 лет: \n"
                + methodsForPerson.getTeenagers());
        System.out.println("Фамилии призывников: ");
        for(var cons: methodsForPerson.getConscripts()){
            System.out.println(cons);
        }
        System.out.println("Работоспособные люди: ");
        for(var person : methodsForPerson.getWorkablePersons()){
            System.out.println(person.toString());
        }
    }

}
