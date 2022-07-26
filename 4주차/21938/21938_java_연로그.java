import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우

    private static int N, M, T;
    private static int[][] avgs;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        avgs = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                avgs[i][j] = (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) / 3;
            }
        }

        T = Integer.parseInt(br.readLine()); // 경계값
        br.close();

        System.out.println(calculate());
    }

    private static int calculate() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isObject(avgs[i][j]) && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int row, int column) {
        visited[row][column] = true;

        for (int i = 0; i < 4; i++) { // directions 크기만큼
            int newRow = row + directions[i][0];
            int newColumn = column + directions[i][1];

            if (newRow < 0 || newRow >= N || newColumn < 0 || newColumn >= M
                    || visited[newRow][newColumn] || !isObject(avgs[newRow][newColumn])) {
                continue;
            }

            dfs(newRow, newColumn);
        }
    }

    private static boolean isObject(int n) {
        return n >= T;
    }
}
