package algorithm_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java_23827_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        long divide = 1_000_000_007;
        long minus = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long number = Integer.parseInt(st.nextToken());
            sum += number;
            minus = (minus + number * sum) % divide;
        }
        sum %= divide;
        long answer = sum * sum - minus;

        System.out.println(answer % divide);
    }
}
