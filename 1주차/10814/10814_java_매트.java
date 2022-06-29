import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Member member = new Member(scanner.nextInt(), scanner.next());
            members.add(member);
        }

        members.sort(comparing(Member::getAge));

        members.forEach(System.out::println);
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
