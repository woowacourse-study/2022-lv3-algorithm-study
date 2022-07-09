import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(input());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = input().split(" ");
            students.add(new Student(Integer.parseInt(data[0]), data[1]));
        }

        Collections.sort(students, (a, b) -> Integer.compare(a.age, b.age));
        for (Student student : students) {
            System.out.println(student.age + " " + student.name);
        }
    }

    static class Student {
        int age;
        String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }
    }
}
