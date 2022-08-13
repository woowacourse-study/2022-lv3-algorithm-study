import java.util.Scanner;

public class Main {

    private static final int INF = 16;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int r = scanner.nextInt();

        int[] items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = scanner.nextInt();
        }

        int[][] edges = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    edges[i][j] = 0;
                    continue;
                }

                edges[i][j] = INF;
            }
        }

        for (int i = 0; i < r; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int length = scanner.nextInt();

            edges[a][b] = length;
            edges[b][a] = length;
        }

        // k => 거쳐가는 노드
        for (int k = 1; k <= n; k++) {
            // i => 출발 노드
            for (int i = 1; i <= n; i++) {
                // j => 도착 노드
                for (int j = 1; j <= n; j++) {
                    edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (edges[i][j] <= m) {
                    count += items[j];
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
    }
}
