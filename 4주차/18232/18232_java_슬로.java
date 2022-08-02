package boj.boj18232;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, start, end;
    static List<Integer>[] map;

    static class Node {

        int point, time;

        public Node(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;
        map = new List[N];
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[x].add(y);
            map[y].add(x);
        }
        System.out.println(findMinimumTime());
    }

    private static int findMinimumTime() {
        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        q.add(new Node(start, 0));
        visited[start] = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int point = node.point;
            int time = node.time;
            if (point == end) {
                return time;
            }
            if (isRange(point - 1) && !visited[point - 1]) {
                visited[point - 1] = true;
                q.add(new Node(point - 1, time + 1));
            }
            if (isRange(point + 1) && !visited[point + 1]) {
                visited[point + 1] = true;
                q.add(new Node(point + 1, time + 1));
            }
            for (Integer nextPoint : map[point]) {
                if (visited[nextPoint]) {
                    continue;
                }
                visited[nextPoint] = true;
                q.add(new Node(nextPoint, time + 1));
            }
        }
        return -1;
    }

    private static boolean isRange(int point) {
        return point >= 0 && point < N;
    }
}
