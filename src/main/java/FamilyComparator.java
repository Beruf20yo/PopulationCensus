import java.util.Comparator;

public class FamilyComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        char[] o1Chars = o1.getFamily().toCharArray();
        char[] o2Chars = o2.getFamily().toCharArray();
        return Integer.compare(Character.getNumericValue(o1Chars[0]), Character.getNumericValue(o2Chars[0]));
    }
}
