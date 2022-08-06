import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] itemCount = new int[N + 1];
        int[][] distance = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            itemCount[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            Arrays.fill(distance[i], MAX);
            distance[i][i] = 0;
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            distance[from][to] = dist;
            distance[to][from] = dist;
        }

        for (int middle = 1; middle <= N; middle++) {
            for (int from = 1; from <= N; from++) {
                for (int to = 1; to <= N; to++) {
                    if (distance[from][to] > distance[from][middle] + distance[middle][to])
                    distance[from][to] = distance[from][middle] + distance[middle][to];
                }
            }
        }

        int maxItemCount = 0;
        for (int from = 1; from <= N; from++) {
            int total = itemCount[from];
            for (int to = 1; to <= N; to++) {
                if (from == to)  continue;
                if (distance[from][to] <= M) total += itemCount[to];
            }
            maxItemCount = Math.max(maxItemCount, total);
        }
        System.out.println(maxItemCount);
    }
}
