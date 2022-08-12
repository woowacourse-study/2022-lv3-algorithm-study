import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, r;
    private static int[] items;
    private static int[][] graph;

    public static void main(String[] args) throws IOException {
        input();

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    graph[j][i] = graph[i][j];
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] <= m) {
                    sum += items[j];
                }
            }
            result = Math.max(sum, result);
        }
        System.out.println(result);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 지역의 개수
        m = Integer.parseInt(st.nextToken()); // 수색범위
        r = Integer.parseInt(st.nextToken()); // 길 개수

        items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        graph = new int[n + 1][n + 1];
        initGraph();

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            putGraph(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        br.close();
    }

    private static void initGraph() {
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], m + 1);
            graph[i][i] = 0;
        }
    }

    private static void putGraph(int edge1, int edge2, int distance) {
        graph[edge1][edge2] = distance;
        graph[edge2][edge1] = distance;
    }
}
