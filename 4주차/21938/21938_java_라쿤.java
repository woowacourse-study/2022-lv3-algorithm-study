import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Main {

    private static final int VISITED = 0;

    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bfs(int[][] tables, int startX, int startY) {
        List<Pos> directions = List.of(
                new Pos(1, 0),
                new Pos(-1, 0),
                new Pos(0, 1),
                new Pos(0, -1)
        );
        Deque<Pos> deque = new ArrayDeque<>();

        deque.add(new Pos(startX, startY));
        tables[startX][startY] = VISITED;

        while (!deque.isEmpty()) {
            Pos current = deque.pollFirst();

            for (Pos direction : directions) {
                int nx = current.x + direction.x;
                int ny = current.y + direction.y;
                if (0 <= nx && nx < tables.length && 0 <= ny && ny < tables[0].length && tables[nx][ny] != VISITED) {
                    tables[nx][ny] = VISITED;
                    deque.add(new Pos(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] temp = input().split(" ");

        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[][] tables = new int[n][m];

        for (int i = 0; i < n; i++) {
            int[] datas = Arrays.stream(input().split(" "))
                    .mapToInt(Integer :: parseInt)
                    .toArray();
            for (int j = 0; j < m; j++) {
                tables[i][j] = datas[3 * j] + datas[3 * j + 1] + datas[3 * j + 2];
                tables[i][j] /= 3;
            }
        }

        int t = Integer.parseInt(input());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tables[i][j] = tables[i][j] >= t ? 255 : 0;
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tables[i][j] != VISITED) {
                    bfs(tables, i, j);
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}

