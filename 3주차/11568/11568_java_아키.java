import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //알고리즘
        dp = new int[N]; // dp[i] = i번째부터 끝까지 고려했을 때 조건에 만족하는 가장 긴 수열의 길이

        //dp 배열을 -1로 초기화
        for (int i = 0; i < N; i++) {
            dp[i] = -1;
        }
        calculate(0);

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    private static void calculate(int num) {
        if (num == N - 1) {
            dp[N - 1] = 1;
            return;
        }

        for (int i = num + 1; i < N; i++) {
            if (dp[i] == -1) {
                calculate(i);
                dp[i] = Math.max(dp[i], 1);
            }

            if (arr[num] < arr[i]) {
                dp[num] = Math.max(dp[num], dp[i] + 1);
            }
        }
    }
}
