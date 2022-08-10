import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_ROAD = 16;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] roads = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                roads[i][j] = MAX_ROAD;
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            // 각각의 방향에 distance 넣어줌. index 값이니까 1빼서
            roads[n1 - 1][n2 - 1] = distance;
            roads[n2 - 1][n1 - 1] = distance;
        }

        // 모든 길에 걸리는 값 확인
        for (int i = 0; i < n; i++) { // 경유지
            for (int j = 0; j < n; j++) { // 출발지
                for (int k = 0; k < n; k++) { // 도착지
                    // 기존에 j -> k 까지의 길이보다 i를 경유해서 가는게 더 작다면 갱신.
                    if (i == j || j == k || i == k)
                        continue;
                    roads[j][k] = Math.min(roads[j][i] + roads[i][k], roads[j][k]);
                }
            }
        }

        // 수색범위 내의 개수 확인
        int result = 0;
        for (int i = 0; i < n; i++) {
            int tmp = items[i];
            for (int j = 0; j < n; j++) {
                if (roads[i][j] <= m) {
                    tmp += items[j];
                }
            }
            result = Math.max(tmp, result);
        }

        System.out.println(result);
    }
}