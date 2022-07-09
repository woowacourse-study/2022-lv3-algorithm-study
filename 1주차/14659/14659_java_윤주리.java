package PS;

import java.util.Arrays;
import java.util.Scanner;

public class OrderArrangement {

    // 1. 활잡이 수&봉우리 수 입력
    // 2. 봉우리 수만큼 반복하여 봉우리 높이 입력
    // 중복 없음
    // 제일 높은 봉우리의 활잡이가 최대 몇명을 처치할 수 있는지 구하기

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] arrows = new int[n];
        for (int i = 0; i < n; i++) {
            arrows[i] = s.nextInt();
        }

        int[] dp = new int[n];

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arrows[i] < arrows[j]) {
                    break;
                }
                dp[i]++;
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
