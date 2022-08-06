package algorithm_study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class java_11582_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int[] sub = new int[N / K];
            for (int j = 0; j < N / K; j++) {
                sub[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(sub);
            Arrays.stream(sub).forEach(it->sb.append(it).append(" "));
        }
        System.out.println(sb);
    }
}
