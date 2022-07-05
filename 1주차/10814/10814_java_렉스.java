import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(i, age, name));
        }
        Collections.sort(members);

        StringBuilder sb = new StringBuilder();
        for (Member m : members) {
            sb.append(m.toString());
        }
        System.out.println(sb);
    }

    static class Member implements Comparable<Member> {
        int signUpOrder;
        int age;
        String name;

        public Member(int signUpOrder, int age, String name) {
            this.signUpOrder = signUpOrder;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }

        @Override
        public int compareTo(Member m) {
            if (this.age > m.age) {
                return 1;
            }
            else if (this.age == m.age) {
                return this.signUpOrder < m.signUpOrder ? -1:1;
            }
            return -1;
        }
    }
}
