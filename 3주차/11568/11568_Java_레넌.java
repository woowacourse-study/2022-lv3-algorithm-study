package boj.p11568;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int value = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (value < dp[j]) {
                        value = dp[j];
                    }
                }
            }
            dp[i] = value + 1;
        }

        bw.write(Arrays.stream(dp).max().getAsInt() + "");
        bw.flush();

        br.close();
        bw.close();
    }
}
