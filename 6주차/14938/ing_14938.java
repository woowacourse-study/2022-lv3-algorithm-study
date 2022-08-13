import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ing_14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int item[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        int arr[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i][i] = -1;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            arr[b][a] = arr[a][b] = l;
        }

        for (int i = 1; i <= n; i++) {
            for (int start = 1; start <= n; start++) {
                if (i == start) {
                    continue;
                }
                for (int end = 1; end <= n; end++) {
                    if (start == end || i == end) {
                        continue;
                    }

                    if (arr[start][i] == 0 || arr[i][end] == 0) {
                        continue;
                    }
                    if (arr[start][i] + arr[i][end] < arr[start][end] || arr[start][end] == 0) {
                        arr[start][end] = arr[start][i] + arr[i][end];
                    }
                }
            }
        }

        int max = 0, sum;
        for (int i = 1; i <= n; i++) {
            sum = 0;
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] <= m && arr[i][j] != 0) {
                    sum += item[j];
                }
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}
