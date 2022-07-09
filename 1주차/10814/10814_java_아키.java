import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 나이가 적은 회원을 먼저
        // 2. 나이가 같다면 먼저 입력한 회원부터
        List<Member> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            list.add(new Member(age, name));
        }

        Collections.sort(list);
        for (int i = 0; i < N; i++) {
            Member member = list.get(i);
            System.out.println(member.getAge() + " " + member.getName());
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
        return this.age - o.age;
    }
}
