import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main10814 {

    static class Member {

        int no, age;
        String name;

        public Member(int no, int age, String name) {
            this.no = no;
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = parseInt(br.readLine());
        PriorityQueue<Member> members = new PriorityQueue<>((o1, o2) -> {
            if (o1.age == o2.age) {
                return o1.no - o2.no;
            }
            return o1.age - o2.age;
        });
        int no = 0;
        while (no < N) {
            st = new StringTokenizer(br.readLine());
            int age = parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(no++, age, name));
        }
        StringBuilder answer = new StringBuilder();
        while (!members.isEmpty()) {
            Member member = members.poll();
            answer.append(member.age)
                    .append(" ")
                    .append(member.name);
            if (members.size() > 0) {
                answer.append("\n");
            }
        }
        System.out.print(answer);
    }

    private static int parseInt(String input) {
        return Integer.parseInt(input);
    }
}
