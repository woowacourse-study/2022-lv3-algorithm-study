package PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 특별상 {

    static class Student implements Comparable<Student> {
        int organizer;
        int referee;

        public Student(int organizer, int referee) {
            this.organizer = organizer;
            this.referee = referee;
        }

        @Override
        public int compareTo(Student target) {
            if (this.referee > target.referee) {
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);

        PriorityQueue<Student> orderByReferee = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            orderByReferee.add(new Student(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }
        //특별상 대상자 중 본상 수상자가 있다면 본상을 받도록 한다
        //본상 수상자를 빼면서 특별상 수상자인지 확인
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            students.add(orderByReferee.poll());
        }
        PriorityQueue<Student> orderByOrganizer = new PriorityQueue<>((o1, o2) -> {
            if (o1.organizer > o2.organizer) {
                return -1;
            }
            return 1;
        });
        orderByOrganizer.addAll(orderByReferee);
        for (int i = 0; i < m; i++) {
            Student student = orderByOrganizer.poll();
            students.add(student);
        }
        int sum = students.stream().mapToInt(student -> student.organizer).sum();
        System.out.println(sum);
    }
}
