package algorithm_study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class java_13905_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        Map<Integer, List<int[]>> edges = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            edges.computeIfAbsent(x, none->new ArrayList<>()).add(new int[] {y, z});
            edges.computeIfAbsent(y, none->new ArrayList<>()).add(new int[] {x, z});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        boolean[] visited = new boolean[N + 1];
        int[] weights = new int[N + 1];
        weights[s] = 10_000_000;
        pq.add(new int[] {s, 0});

        while (!pq.isEmpty()) {
            int node = pq.poll()[0];
            if (visited[node])
                continue;
            visited[node] = true;

            for (int[] edge : edges.getOrDefault(node, new ArrayList<>())) {
                weights[edge[0]] = Math.max(weights[edge[0]], Math.min(weights[node], edge[1]));
                pq.add(edge);
            }
        }
        System.out.println(weights[e]);
    }
}
