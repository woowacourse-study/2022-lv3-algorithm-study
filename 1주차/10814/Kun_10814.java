import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Kun_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i));
        }

        Collections.sort(people, new PersonComparator());
        for (Person person : people) {
            System.out.println(person.age + " " + person.name);
        }
    }

}

class Person {
    String name;
    int age;
    int index;

    public Person(int age, String name, int index) {
        this.name = name;
        this.age = age;
        this.index = index;
    }
}

class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.age == o2.age) {
            return o1.index - o2.index;
        } else {
            return o1.age - o2.age;
        }
    }
}
