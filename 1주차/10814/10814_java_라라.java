import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_10814 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        List<String> people = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String info = sc.nextLine();
            people.add(info);
        }

        people.sort((o1, o2) -> {
            String[] s1 = o1.split(" ");
            int age1 = Integer.parseInt(s1[0]);

            String[] s2 = o2.split(" ");
            int age2 = Integer.parseInt(s2[0]);

            return age1 - age2;
        });

        for (String person : people) {
            System.out.println(person);
        }
    }
}

