import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집의 수
        int M = Integer.parseInt(st.nextToken()); // 다리의 수

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); // 출발위치
        int e = Integer.parseInt(st.nextToken()); // 도착위치

        Map<Integer, List<Route>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            graph.get(h1).add(new Route(h2, k));
            graph.get(h2).add(new Route(h1, k));
        }

        Queue<Route> queue = new PriorityQueue<>();
        queue.add(new Route(s, 0));

        int[] distance = new int[N + 1];
        distance[s] = Integer.MAX_VALUE;
        boolean[] visited = new boolean[N + 1];

        while (!queue.isEmpty()) {
            Route current = queue.poll();
            if (visited[current.destination]) {
                continue;
            }
            visited[current.destination] = true;

            for (Route next : graph.get(current.destination)) {
                distance[next.destination] = Math.max(distance[next.destination],
                        Math.min(distance[current.destination], next.distance));
                queue.add(next);
            }
        }
        System.out.println(distance[e]);
    }

    static class Route implements Comparable<Route> {
        int destination;
        int distance;

        public Route(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }

        @Override
        public int compareTo(Route o) {
            return o.distance - distance;
        }
    }
}
