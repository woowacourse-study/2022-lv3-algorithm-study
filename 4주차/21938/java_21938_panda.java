package algorithm_study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java_21938_panda {
    static int[][] map;
    static boolean[][] visited;
    static int T;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int red = Integer.parseInt(st.nextToken());
                int green = Integer.parseInt(st.nextToken());
                int blue = Integer.parseInt(st.nextToken());

                map[i][j] = (red + green + blue) / 3;
            }
        }
        T = Integer.parseInt(br.readLine());

        visited = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= T && !visited[i][j]) {
                    findMatter(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void findMatter(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>= map[0].length || nx <0 || ny>=map.length || ny<0 || visited[ny][nx] || map[ny][nx] < T) continue;
            findMatter(y+dy[i], x+dx[i]);
        }
    }
}

