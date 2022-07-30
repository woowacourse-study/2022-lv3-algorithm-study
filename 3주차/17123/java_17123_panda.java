package algorithm_study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java_17123_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testNo = 1; testNo <= T; testNo++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] rowSum = new int[N + 1];
            int[] colSum = new int[N + 1];

            for (int r = 1; r <= N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 1; c <= N; c++) {
                    int num = Integer.parseInt(st.nextToken());
                    rowSum[r] += num;
                    colSum[c] += num;
                }
            }

            for (int op = 1; op <= M; op++) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken());
                int c1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                int c2 = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                for (int i = r1; i <= r2; i++) {
                    rowSum[i] += (c2 - c1 + 1) * v;
                }
                for (int i = c1; i <= c2; i++) {
                    colSum[i] += (r2 - r1 + 1) * v;
                }
            }

            StringBuilder sbRow = new StringBuilder();
            StringBuilder sbCol = new StringBuilder();
            for(int i=1; i<=N; i++){
                sbRow.append(rowSum[i]).append(" ");
                sbCol.append(colSum[i]).append(" ");
            }
            System.out.println(sbRow);
            System.out.println(sbCol);
        }
    }
}
