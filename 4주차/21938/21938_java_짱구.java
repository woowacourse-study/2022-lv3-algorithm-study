import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int dy[] = {-1, 0, 1, 0};
    private static final int dx[] = {0, -1, 0, 1};
    private static int n, m;
    private static int[][] graph;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[i][j] = (r + g + b) / 3;
            }
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = calculate(graph[i][j], t);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 255 && !visit[i][j]) {
                    dfs(i, j);
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static int calculate(final int value, final int t) {
        if (value >= t) {
            return 255;
        }
        return 0;
    }

    private static void dfs(final int y, final int x) {
        visit[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m || visit[ny][nx] || graph[ny][nx] == 0) {
                continue;
            }
            dfs(ny, nx);
        }
    }
}
