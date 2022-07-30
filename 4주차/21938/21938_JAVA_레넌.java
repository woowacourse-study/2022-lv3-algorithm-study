package boj.p21938;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int[][] dxy = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                int avg = (Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(
                        st.nextToken())) / 3;
                arr[i][j] = avg;
            }
        }

        int t = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] >= t) {
                    arr[i][j] = 255;
                } else {
                    arr[i][j] = 0;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 255 && !visited[i][j]) {
                    dfs(arr, i, j);
                    answer++;
                }
            }
        }

        bw.write(answer + " ");
        bw.flush();

        bf.close();
        bw.close();
    }

    private static void dfs(int[][] arr, int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < dxy.length; k++) {
            int x = i + dxy[k][0];
            int y = j + dxy[k][1];
            if ((x < 0 || x >= arr.length || y < 0 || y >= arr[0].length)) {
                continue;
            }
            if (visited[x][y]) {
                continue;
            }
            if (arr[x][y] != 255) {
                continue;
            }
            dfs(arr, x, y);
        }
    }
}
