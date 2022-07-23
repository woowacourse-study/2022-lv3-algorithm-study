package BOJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_11866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[] peopleAlive = new boolean[1010];

        for (int i = 0; i <= N; i++) {
            peopleAlive[i] = true;
        }
        List<Integer> answers = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < N; j++) {
            int cnt = 0;
            while (true) {
                i++;
                if (i > N) {
                    i = 1;
                }
                if (!peopleAlive[i]) {
                    continue;
                }
                if (++cnt == K) {
                    answers.add(i);
                    peopleAlive[i] = false;
                    break;
                }
            }
        }
        StringBuilder a = new StringBuilder("<");
        for (int j = 0; j < N; j++) {
            a.append(answers.get(j));
            if (j != N - 1) {
                a.append(", ");
            }
        }
        a.append(">");
        System.out.println(a);
    }
}
