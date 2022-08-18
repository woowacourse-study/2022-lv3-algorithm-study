import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 파이 전체 개수
        int K = Integer.parseInt(st.nextToken()); // 먹으려는 파이 개수

        st = new StringTokenizer(br.readLine());
        int[] pies = new int[N + 1];    // 파이
        int[] sum = new int[N + 1];
        int max = 0;
        for (int i = 1; i <= N; i++) {
            pies[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                sum[i] += pies[i];
                for (int j = N; j > N - K + 1; j--) {
                    sum[i] += pies[j];
                }
            } else if (i <= K) {
                sum[i] = pies[i] + sum[i - 1] - pies[N - K + i];
            } else {
                sum[i] = pies[i] + sum[i - 1] - pies[i - K];
            }
            max = Math.max(sum[i], max);
        }

        System.out.println(max);
    }
}
