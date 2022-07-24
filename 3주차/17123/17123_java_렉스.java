import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            oneCycle(br, sb);
        }
        System.out.print(sb);
    }

    private static void oneCycle(BufferedReader br, StringBuilder sb) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열 생성
        int[][] arr = new int[N][N];
        int[][] sum = new int[2][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각각 row, column 별 합을 미리 구하기
        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            int columnSum = 0;
            for (int j = 0; j < N; j++) {
                rowSum += arr[i][j];
                columnSum += arr[j][i];
            }
            sum[0][i] = rowSum;
            sum[1][i] = columnSum;
        }

        // 연산 읽기 및 수행
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken());

            for (int j = 0; j < N; j++) {
                // row 값 변동 반영
                if (r1 <= j && j <= r2) {
                    sum[0][j] += ((c2 - c1 + 1) * v);
                }
                // column 값 변동 반영
                if (c1 <= j && j <= c2) {
                    sum[1][j] += ((r2 - r1 + 1) * v);
                }
            }
        }

        // 결과 도출
        for (int i = 0; i < N; i++) {
            sb.append(sum[0][i]).append(" ");
        }
        sb.append("\n");
        for (int i = 0; i < N; i++) {
            sb.append(sum[1][i]).append(" ");
        }
        sb.append("\n");
    }
}
