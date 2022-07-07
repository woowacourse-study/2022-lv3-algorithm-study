import java.util.Scanner;

public class BOJ10814 {
    private static class Member implements Comparable<Member> {
        final int age;
        final String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age > o.age) {
                return 1;
            }
            if (this.age == o.age) {
                return 0;
            }
            return -1;
        }

        @Override
        public String toString() {
            return age + " " + name + '\'';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] arr = new String[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.next();
            arr[i][1] = scanner.next();
        }

        final List<Member> list = makeMembers(arr);
        Collections.sort(list);

        for (Member member : list) {
            System.out.println(member.age + " " + member.name);
        }
    }

    private static List<Member> makeMembers(String[][] arr) {
        List<Member> members = new ArrayList<>();
        for (String[] strings : arr) {
            Member member = new Member(Integer.parseInt(strings[0]), strings[1]);
            members.add(member);
        }

        return members;
    }
}
