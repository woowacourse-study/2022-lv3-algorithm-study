import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        ArrayList<Member> members = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            members.add(new Member(Integer.parseInt(s[0]), s[1], i));
        }
        Collections.sort(members);
        for (Member member: members) {
            System.out.println(member);
        }
    }
}

class Member implements Comparable<Member> {
    private final int age;
    private final String name;
    private final int id;

    Member(int age, String name, int id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    @Override
    public int compareTo(Member o) {
        if (age == o.age) {
            return id - o.id;
        }
        return age - o.age;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}
