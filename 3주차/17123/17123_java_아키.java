import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr, dp;
    private static final String BLACK = " ";

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] row = new int[N];
            int[] col = new int[N];
            int[][] arr = new int[N][N];

            //입력
            for (int i = 0; i < N; i++) {
                int rowSum = 0;
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                    rowSum += num;
                }
                row[i] = rowSum;
            }
            for (int j = 0; j < N; j++) {
                int colSum = 0;
                for (int i = 0; i < N; i++) {
                    colSum += arr[i][j];
                }
                col[j] = colSum;
            }

            //계산
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken()) - 1;
                int y1 = Integer.parseInt(st.nextToken()) - 1;
                int x2 = Integer.parseInt(st.nextToken()) - 1;
                int y2 = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken());

                //가로
                int rowPlus = (y2 - y1 + 1) * v;
                for (int k = x1; k <= x2; k++) {
                    row[k] += rowPlus;
                }

                //세로
                int colPlus = (x2 - x1 + 1) * v;
                for (int k = y1; k <= y2; k++) {
                    col[k] += colPlus;
                }
            }

            //출력
            //출력 - 가로
            for (int i = 0; i < N - 1; i++) {
                sb.append(row[i]);
                sb.append(BLACK);
            }
            sb.append(row[N - 1]);
            sb.append(System.lineSeparator());
            //출력 - 세로
            for (int i = 0; i < N - 1; i++) {
                sb.append(col[i]);
                sb.append(BLACK);
            }
            sb.append(col[N - 1]);
            sb.append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
