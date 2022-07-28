import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, T, result;
    private static int[][] visited, arr;
    private static int[] l = {-1, 1, 0, 0};
    private static int[] r = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new int[N][M];
        result = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                int num3 = Integer.parseInt(st.nextToken());

                int average = (num1 + num2 + num3) / 3;
                arr[i][j] = average;
            }
        }

        //경계값 처리
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] >= T) {
                    arr[i][j] = 255;
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        //dfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 255 && visited[i][j] == 0) {
                    result++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(result);
    }

    public static void dfs(int x, int y) {
        if (visited[x][y] == 1) {
            return;
        }

        visited[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + l[i];
            int nextY = y + r[i];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M
                    && arr[nextX][nextY] == 255
                    && visited[nextX][nextY] == 0) {
                dfs(nextX, nextY);
            }
        }
    }
}
