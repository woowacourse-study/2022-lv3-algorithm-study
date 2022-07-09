import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Member> members = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(members);
        StringBuilder sb = new StringBuilder();

        for (Member member : members) {
            sb.append(member.toString());
        }

        System.out.println(sb);
    }

    public static class Member implements Comparable<Member> {

        private int age;
        private String name;

        public Member(final int age, final String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(final Member o) {
            if (age > o.age) {
                return 1;
            } else if (age < o.age) {
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }
    }
}