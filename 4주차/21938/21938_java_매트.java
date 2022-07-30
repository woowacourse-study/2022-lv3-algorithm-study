import java.util.Scanner;

public class Main {

    private static int n, m;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int r = scanner.nextInt();
                int g = scanner.nextInt();
                int b = scanner.nextInt();

                graph[i][j] = (r + g + b) / 3;
            }
        }

        int t = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] >= t) {
                    graph[i][j] = 255;
                    continue;
                }

                graph[i][j] = 0;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 255 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (isLocation(mx, my)) {
                dfs(mx, my);
            }
        }
    }

    private static boolean isLocation(final int x, final int y) {
        return x >= 0 && x < n && y >= 0 && y < m && graph[x][y] != 0 && !visited[x][y];
    }
}
