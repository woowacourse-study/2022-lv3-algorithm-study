import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] rArr = new int[n + 1];
            int[] cArr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    int value = Integer.parseInt(st.nextToken());
                    rArr[j] += value;
                    cArr[k] += value;
                }
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                for (int r = r1; r <= r2; r++) {
                    rArr[r] += (c2 - c1 + 1) * v;
                }
                for (int c = c1; c <= c2; c++) {
                    cArr[c] += (r2 - r1 + 1) * v;
                }
            }

            for (int r = 1; r <= n; r++) {
                sb.append(rArr[r])
                        .append(" ");
            }
            sb.append("\n");
            for (int c = 1; c <= n; c++) {
                sb.append(cArr[c])
                        .append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
