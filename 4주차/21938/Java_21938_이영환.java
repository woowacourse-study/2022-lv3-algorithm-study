import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int n;
    static int m;

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        final String[] nm = bf.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            final String inputLine = bf.readLine();
            final StringTokenizer st = new StringTokenizer(inputLine);
            for (int j = 0; j < m; j++) {
                final Color color = new Color(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                );
                graph.get(i).add(color.calculateAvg());
            }
        }

        final int std = Integer.parseInt(bf.readLine());
        for (Integer line : graph.keySet()) {
            for (int i = 0; i < graph.get(line).size(); i++) {
                final List<Integer> nowLine = graph.get(line);
                if (nowLine.get(i) >= std) {
                    nowLine.set(i, 255);
                } else {
                    nowLine.set(i, 0);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph.get(i).get(j) == 255 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(final int x, final int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >=n || ny >= m) {
                continue;
            }
            if (graph.get(nx).get(ny) != 0 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    static class Color {

        private final int r;
        private final int g;
        private final int b;

        public Color(final int r, final int g, final int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public int calculateAvg() {
            return (r + g + b) / 3;
        }
    }
}
