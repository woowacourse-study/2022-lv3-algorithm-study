import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_4796 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> answers = new ArrayList<>();

        while (true) {
            if (!addAnswer(answers)) {
                break;
            }
        }

        for (int i = 0; i < answers.size(); i++) {
            System.out.println("Case " + (i + 1) + ": " + answers.get(i));
        }
    }

    private static boolean addAnswer(final List<Integer> answers) {
        int L = sc.nextInt();
        int P = sc.nextInt();
        int V = sc.nextInt();

        if (L == 0 && P == 0 && V == 0) {
            return false;
        }

        int answer = V / P * L;
        answer += (Math.min(V % P, L));
        answers.add(answer);

        return true;
    }
}
