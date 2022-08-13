package boj.p14938;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int item[] = new int[n+1];
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        int adj[][] = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            adj[i][i] = -1;
        }

        int from, to, distance;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());
            adj[to][from] = adj[from][to] = distance;
        }

        for (int i = 1; i <= n; i++) {
            for (int start = 1; start <= n; start++) {
                if (i == start) continue;
                for (int end = 1; end <= n; end++) {
                    if (start == end || i == end) continue;
                    if (adj[start][i] == 0 || adj[i][end] == 0) continue;
                    if (adj[start][i]+adj[i][end] < adj[start][end] || adj[start][end] == 0)
                        adj[start][end] = adj[start][i]+adj[i][end];
                }
            }
        }

        int max = 0, sum;
        for (int i = 1; i <= n; i++) {
            sum = 0;
            for (int j = 1; j <= n; j++) {
                if (adj[i][j] <= m && adj[i][j] != 0) sum += item[j];
            }
            max = Math.max(max, sum);
        }

        bw.write(max + "");
        bw.flush();

        br.close();
        bw.close();
    }
}
