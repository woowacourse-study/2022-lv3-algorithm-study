import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, r;
    static int[] arr;
    static List<node>[] list;
    static int result;
    static PriorityQueue<node> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);
        r = Integer.parseInt(size[2]);

        list = new ArrayList[n + 1];
        arr = new int[n + 1];

        String[] item = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(item[i - 1]);
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < r; i++) {
            String[] local = br.readLine().split(" ");
            int start = Integer.parseInt(local[0]);
            int end = Integer.parseInt(local[1]);
            int distance = Integer.parseInt(local[2]);

            list[start].add(new node(end, distance));
            list[end].add(new node(start, distance));
        }

        for (int i = 1; i <= n; i++) {
            solve(i);
        }

        System.out.println(result);
    }

    public static void solve(int start) {

        int temp = arr[start];
        boolean[] check = new boolean[n + 1];
        check[start] = true;

        for (node now : list[start]) {
            queue.add(now);
        }

        while (!queue.isEmpty()) {
            node poll = queue.poll();

            if (!check[poll.end] && poll.distance <= m) {
                temp += arr[poll.end];
                check[poll.end] = true;

                for (node next : list[poll.end]) {
                    queue.add(new node(next.end, poll.distance + next.distance));
                }
            }
        }
        result = Math.max(temp, result);
    }

    class node implements Comparable<node> {
        int end;
        int distance;

        public node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(node o) {
            return this.distance - o.distance;
        }
    }
}


