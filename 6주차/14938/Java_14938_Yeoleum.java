import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final int INF = (int)1e9;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();
    public static int[] distance;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[] item = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n; i++){
            graph.add(new ArrayList<>());
            item[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph.get(a - 1).add(new Vertex(b - 1, l));
            graph.get(b - 1).add(new Vertex(a - 1, l));
        }
        distance = new int[n];

        for (int i = 0; i < n; i++) {
            int start = i;
            Arrays.fill(distance, INF);
            dijkstra(start);

            int sum = 0;
            for (int j = 0; j < n; j++) {
                if(j == start){
                    sum += item[j];
                    continue;
                }

                if(distance[j] == INF){
                    continue;
                }

                if(distance[j] <= m){
                    sum += item[j];
                }
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(start, 0));
        distance[start] = 0;
        while(!pq.isEmpty()){
            Vertex v = pq.poll();
            int now = v.index;
            int dist = v.distance;
            if(distance[now] < dist){
                continue;
            }
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = distance[now] + graph.get(now).get(i).distance;
                if(cost < distance[graph.get(now).get(i).index]){
                    distance[graph.get(now).get(i).index] = cost;
                    pq.offer(new Vertex(graph.get(now).get(i).index, cost));
                }
            }
        }
    }
}

class Vertex implements Comparable<Vertex>{

    int index;
    int distance;

    public Vertex(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(Vertex vertex) {
        return this.distance - vertex.distance;
    }
}
