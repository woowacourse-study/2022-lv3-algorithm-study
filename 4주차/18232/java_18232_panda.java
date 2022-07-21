package algorithm_study.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class java_18232_panda {
    static int N, M, S, E;
    static Map<Integer, Set<Integer>> teleport;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        teleport = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int firstSpot = Integer.parseInt(st.nextToken());
            int secondSpot = Integer.parseInt(st.nextToken());
            teleport.computeIfAbsent(firstSpot, k -> new HashSet<>()).add(secondSpot);
            teleport.computeIfAbsent(secondSpot, k -> new HashSet<>()).add(firstSpot);
        }
        System.out.println(findMinTime());
    }

    private static int findMinTime() {
        visited[S] = true;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(List.of(S, 0));
        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int departure = current.get(0);
            int timeSpent = current.get(1) + 1;

            Set<Integer> nextSpots = teleport.getOrDefault(departure, new HashSet<>());
            Stream.of(departure - 1, departure + 1)
                .filter(x -> x > 0 && x <= N)
                .forEach(nextSpots::add);

            for (int next : nextSpots) {
                if (visited[next])
                    continue;
                if (next == E) {
                    return timeSpent;
                }
                visited[next] = true;
                queue.add(List.of(next, timeSpent));
            }
        }
        return 0;
    }
}
