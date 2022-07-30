import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class josh_java_21938 {

    private static final int VISITED = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                arr[i][j] = RgbAverage(st);
            }
        }
        int threshold = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 0; i<N; ++i) {
            for (int j= 0; j<M; ++j) {
                answer += bfs(arr, i, j, N, M, threshold);
            }
        }
        System.out.println(answer);
    }

    private static int bfs(int[][] arr, int startX, int startY, int N, int M, int threshold) {
        Queue<Integer> xBucket = new LinkedList<>();
        Queue<Integer> yBucket = new LinkedList<>();
        if (arr[startX][startY] == VISITED || arr[startX][startY] < threshold) {
            return 0;
        }

        xBucket.add(startX);
        yBucket.add(startY);

        while (!xBucket.isEmpty()) {
            int x = xBucket.poll();
            int y = yBucket.poll();
            if (x < 0 || y < 0 || x >= N || y >= M) {
                continue;
            }
            if (arr[x][y] < threshold) {
                continue;
            }
            xBucket.add(x-1); xBucket.add(x+1); xBucket.add(x); xBucket.add(x);
            yBucket.add(y); yBucket.add(y); yBucket.add(y-1); yBucket.add(y+1);
            arr[x][y] = VISITED;
        }
        return 1;
    }

    private static int RgbAverage(StringTokenizer st) {
        return (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())) / 3;
    }
}
