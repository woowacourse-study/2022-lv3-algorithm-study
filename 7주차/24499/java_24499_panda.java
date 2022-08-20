package algorithm_study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java_24499_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] pies = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pies[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += pies[i];
        }

        long max = sum;
        for (int i = K; i < N + K; i++) {
            sum += (pies[i % N] - pies[i - K]);
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
