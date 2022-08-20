import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Bridge implements Comparable<Bridge> {
        int weight, home1, home2;

        public Bridge(int weight, int home1, int home2) {
            this.weight = weight;
            this.home1 = home1;
            this.home2 = home2;
        }

        @Override
        public int compareTo(Bridge bridge) {
            return Integer.compare(bridge.weight, this.weight);
        }
    }

    static int n, m, s, e;
    static int[] parents;
    static List<Bridge> bridges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            bridges.add(new Bridge(k, h1, h2));
        }

        Collections.sort(bridges);


        for (Bridge bridge : bridges) {
            union(bridge.home1, bridge.home2);
            if (find(s) == find(e)) {
                // 시작 -> 끝의 최대 신장 트리가 완성되었을 경우 그냥 나와버림.
                System.out.println(bridge.weight);
                break;
            }
        }

        // 해당 경우는 최대 신장 트리가 완성되지 않았을 경우
        if (find(s) != find(e)) {
            System.out.println(0);
        }

    }

    private static void union(int home1, int home2) {
        int root1 = find(home1);
        int root2 = find(home2);

        if (root1 <= root2) {
            parents[root2] = root1;
        } else {
            parents[root1] = root2;
        }
    }

    private static int find(int home) {
        if (parents[home] == home) {
            return home;
        } else {
            return parents[home] = find(parents[home]);
        }
    }
}