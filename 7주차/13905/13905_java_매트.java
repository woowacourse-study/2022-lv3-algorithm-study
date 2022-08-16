import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    private static int n, m, s, e;
    private static int[] parent;
    private static PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
    private static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        s = scanner.nextInt();
        e = scanner.nextInt();

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int cost = scanner.nextInt();

            priorityQueue.add(new Edge(a, b, cost));
        }

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        while (!priorityQueue.isEmpty()) {
            Edge polledEdge = priorityQueue.poll();
            if (findParent(polledEdge.nodeA) != findParent(polledEdge.nodeB)) {
                unionParent(polledEdge.nodeA, polledEdge.nodeB);

                if (findParent(s) == findParent(e)) {
                    result = polledEdge.distance;
                    break;
                }
            }
        }

        System.out.println(result);
    }

    private static int findParent(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    private static class Edge implements Comparable<Edge> {
        private int nodeA;
        private int nodeB;
        private int distance;

        public Edge(final int nodeA, final int nodeB, final int distance) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }

        @Override
        public int compareTo(final Edge o) {
            return o.distance - this.distance;
        }
    }
}
