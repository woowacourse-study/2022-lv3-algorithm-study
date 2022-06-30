import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            members.add(new Member(scanner.nextInt(), scanner.next()));
        }

        List<LinkedList<Member>> counts = IntStream.rangeClosed(0, 200)
                .mapToObj(ignored -> new LinkedList<Member>())
                .collect(toList());

        for (Member member : members) {
            counts.get(member.getAge()).add(member);
        }

        for (Queue<Member> count : counts) {
            while (!count.isEmpty()) {
                System.out.println(count.poll());
            }
        }
    }
}

class Member {

    private final int age;
    private final String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}
