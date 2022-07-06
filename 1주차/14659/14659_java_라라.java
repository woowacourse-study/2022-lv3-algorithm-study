import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ_14659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int N = sc.nextInt();
        List<Integer> mountains = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            mountains.add(sc.nextInt());
        }

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i + 1; j < N; j++) {
                if (mountains.get(i) < mountains.get(j)) {
                    break;
                }
                sum++;
            }
            if (sum > answer) {
                answer = sum;
            }
        }

        System.out.println(answer);
    }
}
