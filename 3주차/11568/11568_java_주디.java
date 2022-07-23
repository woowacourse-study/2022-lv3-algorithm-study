package PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 민균이의_계략 {
    //

    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        //findMaxElement(1, n);
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    private static void findMax(int i) {
        if (i > 0) {
            if (arr[i] > arr[i - 1]) {
                dp[i] = dp[i + 1] + 1;
            }
            findMax(i - 1);
        }
    }

    private static void findMaxElement(int index, int n) {
        if (index < n) {
            if (arr[index - 1] < arr[index]) {
                dp[index] = dp[index - 1] + 1;
            }
            findMaxElement(index + 1, n);
        }
    }
}
