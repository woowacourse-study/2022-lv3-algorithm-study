import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 지역 수
        int m = Integer.parseInt(st.nextToken()); // 수색 범위
        int r = Integer.parseInt(st.nextToken()); // 길의 개수

        st = new StringTokenizer(br.readLine());
        int[] items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] edges = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(edges[i], 16);
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            edges[n1][n2] = length;
            edges[n2][n1] = length;
        }

        // 플로이드 와샬~
        for (int i = 1; i <= n; i++) { // 거쳐가는 곳
            for (int j = 1; j <= n; j++) { // 출발지
                for (int k = 1; k <= n; k++) { // 도착지
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    edges[j][k] = Math.min(edges[j][i] + edges[i][k], edges[j][k]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int numOfItems = items[i];
            for (int j = 1; j <= n; j++) {
                if (edges[i][j] <= m) {
                    numOfItems += items[j];
                }
            }
            max = Math.max(numOfItems, max);
        }
        System.out.println(max);
    }
}
