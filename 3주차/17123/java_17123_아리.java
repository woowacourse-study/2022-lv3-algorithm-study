import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        // TestCase t 만큼 만복
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] row = new int[N + 1]; // 행의 합
            int[] col = new int[N + 1]; // 열의 합

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    row[i] += num;
                    col[j] += num;
                }
            }

            // 연산 횟수 M 만큼 반복
            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                // 행의 합 연산
                for (int i = r1; i <= r2; i++) {
                    row[i] += (c2 - c1 + 1) * v;
                }

                // 열의 합 연산
                for (int i = c1; i <= c2; i++) {
                    col[i] += (r2 - r1 + 1) * v;
                }

            }

            // 행의 합 결과 출력
            for (int i = 1; i <= N; i++) {
                result.append(row[i] + " ");
            }
            result.append("\n");

            // 열의 합 결과 출력
            for (int i = 1; i <= N; i++) {
                result.append(col[i] + " ");
            }
            result.append("\n");

        }

        System.out.println(result);
    }
}
