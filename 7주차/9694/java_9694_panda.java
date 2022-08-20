package algorithm_study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class java_9694_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                map.computeIfAbsent(x, none -> new ArrayList<>()).add(new int[] {y, z});
                map.computeIfAbsent(y, none -> new ArrayList<>()).add(new int[] {x, z});
            }

            Map<Integer, Integer> distance = new HashMap<>();
            Map<Integer, Integer> before = new HashMap<>();
            boolean[] visited = new boolean[M];

            for (int i = 0; i < M; i++) {
                distance.put(i, Integer.MAX_VALUE);
                before.put(i, -1);
            }
            distance.replace(0, 0);

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            pq.add(new int[] {0, distance.get(0)});

            Stack<Integer> path = new Stack<>();

            while (!pq.isEmpty()) {
                int node = pq.poll()[0];

                if (visited[node])
                    continue;
                visited[node] = true;

                if (node == M - 1) {
                    while (node != -1) {
                        path.push(node);
                        node = before.get(node);
                    }
                    break;
                }

                for (int[] edge : map.getOrDefault(node, new ArrayList<>())) {
                    if (distance.get(edge[0]) > distance.get(node) + edge[1]) {
                        distance.replace(edge[0], distance.get(node) + edge[1]);
                        before.replace(edge[0], node);
                        pq.add(new int[] {edge[0], distance.get(edge[0])});
                    }
                }
            }

            StringBuilder sb = new StringBuilder("Case #").append(testCase).append(": ");
            if (path.isEmpty()) {
                System.out.println(sb.append(-1));
                continue;
            }
            while (!path.isEmpty()) {
                sb.append(path.pop()).append(" ");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }
}
