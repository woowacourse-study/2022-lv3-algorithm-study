import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class josh_java_14938 {

    private static int INF = 100000;

    private static List<Integer> items = new ArrayList<>();
    private static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        adj = new int[N][N];
        for (int i = 0; i<N; ++i) {
            for (int j = 0; j<N; ++j) {
                if (i == j) {
                    adj[i][j] = 0;
                } else {
                    adj[i][j] = INF;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i< N; ++i) {
            items.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i<R; ++i) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());
            adj[from][to] = dist;
            adj[to][from] = dist;
        }

        // 플로이드 와샬 알고리즘
        for (int k = 0; k<N; ++k) {
            for (int i = 0; i<N; ++i) {
                for (int j = 0; j<N; ++j) {
                    if (adj[i][j] > adj[i][k] + adj[k][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; ++i) {
            int ansCandidate = 0;
            for (int j = 0; j<N; ++j) {
                if (adj[i][j] <= M) {
                    ansCandidate += items.get(j);
                }
            }
            if (ans < ansCandidate) {
                ans = ansCandidate;
            }
        }
        System.out.println(ans);
    }
}
