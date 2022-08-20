import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int n, m, s, e;
    private static int[] dp, visited;
    private static List<ArrayList<Node>> list;
    private static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken()) - 1;
        e = Integer.parseInt(st.nextToken()) - 1;

        dp = new int[n];
        visited = new int[n];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        dp[s] = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight));
        }

        // 다익스트라
        dijkstra();

        System.out.println(dp[e]);
    }

    private static void dijkstra() {
        pq.add(new Node(s, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int end = node.index;

            if (visited[end] == 1) {
                continue;
            }
            visited[end] = 1;

            ArrayList<Node> nodes = list.get(end);
            for (Node n : nodes) {
                int next = n.index;
                int weight = n.weight;
                dp[next] = Math.max(dp[next], Math.min(dp[end], weight));
                pq.add(n);
            }
        }
    }
}

class Node implements Comparable<Node> {
    int index;
    int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return o.weight - this.weight;
    }
}
