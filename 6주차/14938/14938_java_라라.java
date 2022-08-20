
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, R;
    static int[] weapons;
    static int[][] floyd;

    public static void main(String[] args) throws IOException {
        input();
        floydWashall();
        System.out.println(findMaxItems());
    }

    public static void floydWashall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (floyd[i][j] > floyd[i][k] + floyd[k][j]) {
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                    }
                }
            }
        }
    }

    public static int findMaxItems() {
        int maxItems = 0;
        for (int i = 1; i <= N; i++) {
            int items = 0;
            for (int j = 1; j <= N; j++) {
                if (floyd[i][j] <= M) {
                    items += weapons[j];
                }
            }
            if (maxItems < items) {
                maxItems = items;
            }
        }

        return maxItems;
    }

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        weapons = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            weapons[i] = Integer.parseInt(st.nextToken());
        }

        floyd = new int[N + 1][N + 1];
        for (int[] f : floyd) {
            Arrays.fill(f, 2000);
        }

        for (int i = 1; i <= N; i++) {
            floyd[i][i] = 0;
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            floyd[a][b] = Math.min(floyd[a][b], c);
            floyd[b][a] = Math.min(floyd[b][a], c);
        }
    }
}
