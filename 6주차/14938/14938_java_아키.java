import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, M, R;
    private static int[] item, visited, curDist;
    private static int[][] dist;
    private static int INF = 1000000;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        item = new int[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            item[i] = Integer.parseInt(input[i]);
        }

        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                dist[i][j] = INF;
            }
        }

        //노드간 거리
        for (int i = 0; i < R; i++) {
            input = br.readLine().split(" ");
            int num1 = Integer.parseInt(input[0])-1;
            int num2 = Integer.parseInt(input[1])-1;
            int distance = Integer.parseInt(input[2]);
            dist[num1][num2] = distance;
            dist[num2][num1] = distance;
        }

        //알고리즘
        Main m = new Main();
        int[] itemSearch = new int[N];
        for (int start = 0; start < N; start++) {

            visited = new int[N];
            curDist = new int[N];
            for (int end = 0; end < N; end++) {
                curDist[end] = dist[start][end];
            }

            m.dijkstra(start);
            int sum = 0;
            for (int end = 0; end < N; end++) {
                if (curDist[end] <= M) {
                    sum += item[end];
                }
            }

            itemSearch[start] = sum;
        }

        //출력
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(itemSearch[i], max);
        }
        System.out.println(max);
    }

    private void dijkstra(int start) {

        for (int i = 0; i < N; i++) {
            int idx = getSmallIndex();
            visited[idx] = 1;
            for (int end = 0; end < N; end++) {
                if (curDist[idx] + dist[idx][end] < curDist[end]) {
                    curDist[end] = curDist[idx] + dist[idx][end];
                }
            }
        }
    }

    private int getSmallIndex() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            //아직 방문하지 않은 노드 중에서
            if (visited[i] == 0) {
                min = Math.min(curDist[i], min);
            }
        }

        int idx = -1;
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0 && curDist[i] == min) {
                idx = i;
                break;
            }
        }
        return idx;
    }

}
