import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 1_000_000;
    private static int N, M;
    private static List<ArrayList<Node>> list;
    private static List<ArrayList<Integer>> people;
    private static int[] d, visited;

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            d = new int[M];
            visited = new int[M];
            list = new ArrayList<>();
            people = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                list.add(new ArrayList<>());
                people.add(new ArrayList<>());
                d[i] = INF;
            }
            d[0] = 0;

            //관계 연결
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                int num3 = Integer.parseInt(st.nextToken());
                list.get(num1).add(new Node(num2, num3));
                list.get(num2).add(new Node(num1, num3));
            }

            //다익스트라
            dijkstra();

            System.out.print("Case #" + test_case + ":");
            if (d[M - 1] == INF) {
                System.out.print(" -1");
            } else {
                int size = people.get(M - 1).size();
                for (int i = 0; i < size; i++) {
                    System.out.print(" " + people.get(M - 1).get(i));
                }
                System.out.print(" " + (M - 1));
            }
            System.out.println();
        }

    }

    //시작점 0, 끝점 M-1
    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

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
                int dist = n.dist;

                if (visited[next] == 0 && d[end] + dist < d[next]) {
                    d[next] = d[end] + dist;
                    pq.add(new Node(next, d[next]));
                    people.get(next).clear();
                    people.get(next).addAll(people.get(end));
                    people.get(next).add(end);
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int index;
    int dist;

    public Node(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
        return this.dist - o.dist;
    }
}
