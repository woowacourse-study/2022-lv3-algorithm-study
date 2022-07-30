import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += Integer.parseInt(st.nextToken());
                }
                matrix[i][j] = sum / 3;
            }
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] >= T) {
                    matrix[i][j] = 255;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 255) {
                    bfs(dx, dy, matrix, i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    private static void bfs(int[] dx, int[] dy, int[][] matrix, int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point polled = queue.poll();
            for (int k = 0; k < 4; k++) {
                int newX = polled.x + dx[k];
                int newY = polled.y + dy[k];
                if (0 <= newX && newX < M && 0 <= newY && newY < N && matrix[newY][newX] == 255) {
                    matrix[newY][newX] = 0;
                    queue.offer(new Point(newX, newY));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
