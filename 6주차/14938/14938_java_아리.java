import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        // 각 지역의 아이템 수
        int[] item = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        // 각 지역 사이의 길이
        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], 16); // 최대 15이니 16이면 닿을 수 없는걸로
            map[i][i] = 0; // 자기자신까지의 거리는 0
        }
        while (r-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            map[a][b] = l;
            map[b][a] = l;
        }

        // 플로이드와샬
        for (int k = 1; k <= n; k++) { // 경유지
            for (int i = 1; i <= n; i++) { // 출발지
                for (int j = 1; j <= n; j++) { // 도착지
                    // 경유한 것이 직선거리보다 짧다면 갱신!
                    if (map[k][i] + map[k][j] < map[i][j]) {
                        map[i][j] = map[k][i] + map[k][j];
                    }
                }
            }
        }

        // 결과 구하기
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= n; j++) {
                if (map[i][j] <= m) { // 수색범위 이내라면 획득가능!
                    max += item[j];
                }
            }
            result = Math.max(result, max);
        }

        System.out.println(result);
    }
}
