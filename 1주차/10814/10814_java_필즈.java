import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String initInput = br.readLine();

        int input = Integer.parseInt(initInput);

        Person[] people = new Person[input];

        for (int i = 0; i < input; i++) {
            String personInput = br.readLine();
            String[] personArr = personInput.split(" ");

            int age = Integer.parseInt(personArr[0]);
            String name = personArr[1];

            people[i] = new Person();
            people[i].age = age;
            people[i].name = name;
            people[i].createdAt = i + 1;
        }

        Arrays.sort(people, comparator());

        for (int i = 0; i < input; i++) {
            out.println(people[i].print());
        }

        br.close();
    }

    private static Comparator<Person> comparator() {
        return (people1, people2) -> {
            if (people1.age > people2.age) {
                return 1;
            } else if (people1.age == people2.age && people1.createdAt > people2.createdAt) {
                return 1;
            }
            return -1;
        };
    }

    private static class Person {
        int age;
        String name;
        int createdAt;

        public Person() {
        }

        public String print() {
            return age + " " + name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    ", createdAt=" + createdAt +
                    '}';
        }
    }
}
