import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int T;
    private static int[][] pixels;
    private static boolean[][] visited;
    private static int[] di = {1, 0, -1, 0};
    private static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        pixels = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int r = parseInt(st.nextToken());
                int g = parseInt(st.nextToken());
                int b = parseInt(st.nextToken());
                pixels[i][j] = (r + g + b) / 3;
            }
        }

        T = parseInt(br.readLine());
        visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (pixels[i][j] < T || visited[i][j]) {
                    continue;
                }
                dfs(i, j);
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }

    private static void dfs(final int i, final int j) {
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            if (ni >= N || nj >= M || ni < 0 || nj < 0 || visited[ni][nj] || pixels[ni][nj] < T) {
                continue;
            }
            dfs(ni, nj);
        }
    }
}
