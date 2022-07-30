import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int T;
    private static int[][] pixels;
    private static boolean[][] visited;
    private static Queue<Index> queue;
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
        queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (pixels[i][j] < T || visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                bfs(i, j);
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }

    private static void bfs(int i, int j) {
        while (true) {
            if (!queue.isEmpty()) {
                final Index index = queue.poll();
                i = index.i;
                j = index.j;
            }
            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (ni >= N || nj >= M || ni < 0 || nj < 0 || visited[ni][nj] || pixels[ni][nj] < T) {
                    continue;
                }
                visited[ni][nj] = true;
                queue.add(new Index(ni, nj));
            }
            if (queue.isEmpty()) {
                break;
            }
        }
    }

    private static class Index {
        int i;
        int j;

        public Index(final int i, final int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            final Index index = (Index) o;
            return i == index.i && j == index.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
