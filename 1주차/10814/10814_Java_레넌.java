package boj.p10814;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Person[] persons = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Person person = new Person(age, name);
            persons[i] = person;
        }
        Arrays.sort(persons);

        for (Person person : persons) {
            bw.write(person + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }

    public static class Person implements Comparable<Person> {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if (this.age > o.age) {
                return 1;
            }
            if (this.age == o.age) {
                return 0;
            }
            return -1;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }
}
