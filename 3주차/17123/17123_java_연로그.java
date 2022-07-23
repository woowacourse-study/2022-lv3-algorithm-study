import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st = new StringTokenizer("");
    private static final StringBuilder sb = new StringBuilder();
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            initArray(N);
            calculate(M);
            drawForPrint(N);
        }

        System.out.println(sb);
        br.close();
    }

    private static void initArray(int n) throws IOException {
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void calculate(int m) throws IOException {
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for (int i = r1 - 1; i < r2; i++) {
                for (int j = c1 - 1; j < c2; j++) {
                    arr[i][j] += v;
                }
            }
        }
    }

    private static void drawForPrint(int n) {
        // 행의 합
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += arr[i][j];
            }
            sb.append(sum)
                    .append(" ");
        }
        sb.append("\n");

        // 열의 합
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += arr[j][i];
            }
            sb.append(sum)
                    .append(" ");
        }
        sb.append("\n");
    }
}
