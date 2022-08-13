import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, List<Target>> map = new HashMap<>();
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());
            map.putIfAbsent(start, new ArrayList<>());
            map.putIfAbsent(end, new ArrayList<>());
            // 양방향 경로 저장
            map.get(start).add(new Target(end, distance));
            map.get(end).add(new Target(start, distance));
        }

        boolean[] visited = new boolean[n];
        int[] minDistance = new int[n]; // 방문할 수 있는 최단 거리
        PriorityQueue<Target> queue = new PriorityQueue<>(); // 거리가 짧은 Target 우선시

        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            queue.add(new Target(i, 0)); // 낙하 지역

            int count = 0;
            Arrays.fill(minDistance, Integer.MAX_VALUE);
            Arrays.fill(visited, false);

            while (!queue.isEmpty()) {
                Target current = queue.poll();
                // 현재 수색 지역
                if (visited[current.num]) {
                    continue;
                }

                visited[current.num] = true;
                count += items[current.num];
                int passedDistance = current.distance; // 이때까지 지나온 거리

                if (!map.containsKey(current.num)) {
                    // 길 없음
                    continue;
                }

                for (Target next : map.get(current.num)) {
                    int distance = next.distance + passedDistance; // 다음 지역까지 거리
                    if (distance <= m && distance < minDistance[next.num]) {
                        // 범위 내에 있고 최단 거리면 다음 수색 지역으로 추가
                        queue.add(new Target(next.num, distance));
                        minDistance[next.num] = distance;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        bw.write(Integer.toString(maxCount));
        bw.flush();
    }

    static class Target implements Comparable<Target> {
        int num;
        int distance;

        public Target(final int num, final int distance) {
            this.num = num;
            this.distance = distance;
        }

        @Override
        public int compareTo(final Target o) {
            return Integer.compare(distance, o.distance);
        }
    }
}
