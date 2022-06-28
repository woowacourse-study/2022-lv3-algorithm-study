package algorithm_study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class java_10814_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        List<Member> members = new LinkedList<>();

        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(age, name));
        }

        Collections.sort(members);

        for (Member member : members) {
            System.out.printf("%d %s\n", member.getAge(), member.getName());
        }
    }
}

class Member implements Comparable<Member> {
    private int age;
    private String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Member o) {
        return age - o.getAge();
    }
}
