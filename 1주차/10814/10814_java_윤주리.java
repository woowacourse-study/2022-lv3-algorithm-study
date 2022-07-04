package PS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AgeSort {

    static class People {

        int age;
        String name;

        public People(int age, String name) {
            this.age = age;
            this.name = name;
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        List<People> peoples = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int age = s.nextInt();
            String name = s.next();

            peoples.add(new People(age, name));
        }

        peoples.sort(Comparator.comparingInt(a -> a.age));

        peoples.forEach(people -> System.out.println(people.age + " " + people.name));
    }
}
