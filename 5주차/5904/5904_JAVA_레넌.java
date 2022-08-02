package boj.p5904;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        dp = new int[31];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 3;
        int i = 0;
        while (dp[i] <= N) {
            i++;
            dp[i] = dp[i - 1] + i + 3 + dp[i - 1];
        }

        bw.write(moo(N));
        bw.flush();

        br.close();
        bw.close();
    }

    public static String moo(int n) {
        int i = 31;

        if (n == 1) {
            return "m";
        } else if (n <= 3) {
            return "o";
        } else {
            while (dp[i - 1] >= n) {
                i--;
            }
            int mid = dp[i - 1] + i + 3;
            if (mid < n) {
                return moo(n - mid);
            } else if (n == dp[i - 1] + 1) {
                return "m";
            } else {
                return "o";
            }
        }
    }
}
