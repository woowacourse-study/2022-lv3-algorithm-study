import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class java_10814_루키 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            persons.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(persons);
        for (Person person : persons) {
            System.out.println(person.age + " " + person.name);
        }
    }

    public static class Person implements Comparable<Person> {

        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if (this.age == o.age) {
                return 0;
            }
            return this.age - o.age;
        }
    }
}
