import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11568 {

    private static int n;
    private static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        calculate(0);

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    private static void calculate(int num) {
        if (num == n - 1) {
            dp[n - 1] = 1;
            return;
        }

        for (int i = num + 1; i < n; i++) {
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
