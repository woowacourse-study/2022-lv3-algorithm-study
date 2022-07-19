import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Member> members = new PriorityQueue<>();
        int seq = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            members.add(new Member(seq++, age, name));
        }

        while (!members.isEmpty()) {
            System.out.println(members.poll());
        }
    }
}

class Member implements Comparable<Member> {
    int id;
    int age;
    String name;

    public Member(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member o) {
        if (o.age - age == 0) {
            return id - o.id;
        }
        return age - o.age;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}
