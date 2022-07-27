import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int s = scanner.nextInt();
        int e = scanner.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        System.out.println(bfs(n, s, e));
    }

    private static int bfs(int n, int s, int e) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(s, 0));
        visited[s] = true;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int v = pair.v;
            int count = pair.count;

            if (v == e) {
                return count;
            }

            // x + 1 지점으로 이동
            if (v + 1 <= n && !visited[v + 1]) {
                visited[v + 1] = true;
                queue.add(new Pair(v + 1, count + 1));
            }

            // x - 1 지점으로 이동
            if (v - 1 > 0 && !visited[v - 1]) {
                visited[v] = true;
                queue.add(new Pair(v - 1, count + 1));
            }

            // x에 위치한 텔레포트와 연결된 지점으로 이동 가능
            List<Integer> vertexes = graph.get(v);
            for (Integer vertex : vertexes) {
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    queue.add(new Pair(vertex, count + 1));
                }
            }
        }

        return 0;
    }

    private static class Pair {
        private final int v;
        private final int count;

        public Pair(final int v, final int count) {
            this.v = v;
            this.count = count;
        }
    }
}
