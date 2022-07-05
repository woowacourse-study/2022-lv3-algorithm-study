import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        class Member implements Comparable<Member> {
            int age;
            String name;

            public Member(int age, String name) {
                this.age = age;
                this.name = name;
            }

            @Override
            public int compareTo(Member member) {
                return Integer.compare(this.age, member.age);
            }

            @Override
            public String toString() {
                return age + " " + name;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            members.add(new Member(Integer.parseInt(input[0]), input[1]));
        }
        Collections.sort(members);

        for (Member member : members) {
            System.out.println(member);
        }
    }
}