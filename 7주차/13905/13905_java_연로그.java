import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, S, E;
    private static List<int[]> map[];
    private static boolean[] visited;
    private static int[] weights;

    public static void main(String[] args) throws IOException {
        input();
        calculate();
        System.out.println(weights[E]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 집의 개수
        M = Integer.parseInt(st.nextToken()); // 다리의 개수
        visited = new boolean[N + 1];
        weights = new int[N + 1];
        map = new ArrayList[N + 1];

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()); // 출발 위치
        E = Integer.parseInt(st.nextToken()); // 도착 위치

        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<int[]>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int point1 = Integer.parseInt(st.nextToken());
            int point2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[point1].add(new int[]{point2, weight});
            map[point2].add(new int[]{point1, weight});
        }
        br.close();
    }

    private static void calculate() {
        // 일반 Queue를 사용하다 정답이 안나와서 다른 사람의 풀이를 보고나서야 PriorityQueue를 적용했습니다.
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(final int[] o1, final int[] o2) {
                return o2[1] - o1[1];
            }
        });
        queue.add(new int[]{S, 0});
        weights[S] = 1000000;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (visited[now[0]]) {
                continue;
            }
            visited[now[0]] = true;
            int size = map[now[0]].size();
            for (int i = 0; i < size; i++) {
                queue.add(map[now[0]].get(i));
                int nextPoint = map[now[0]].get(i)[0];
                int nextWeight = map[now[0]].get(i)[1];
                weights[nextPoint] = Math.max(weights[nextPoint], Math.min(weights[now[0]], nextWeight));
            }
        }
    }
}
