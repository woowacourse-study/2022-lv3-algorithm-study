import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int soong = Integer.parseInt(st.nextToken()) - 1;
        int hyebin = Integer.parseInt(st.nextToken()) - 1;

        Map<Integer, List<Target>> bridges = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            bridges.putIfAbsent(start, new ArrayList<>());
            bridges.putIfAbsent(end, new ArrayList<>());

            // 양방향 경로저장
            bridges.get(start).add(new Target(end, weight));
            bridges.get(end).add(new Target(start, weight));
        }

        PriorityQueue<Target> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[N];
        int[] maxWeight = new int[N];

        queue.addAll(bridges.getOrDefault(soong, List.of())); // 숭이의 위치에서 갈 수 있는 경로 저장
        // 출발 위치 방문처리
        visited[soong] = true;
        maxWeight[soong] = Integer.MAX_VALUE;

        while(!queue.isEmpty()) {
            final Target current = queue.poll();
            if (visited[current.number] && maxWeight[current.number] >= current.weight) {
                continue; // 전에 방문했을 때보다 적게 가져왔으면 skip
            }

            visited[current.number] = true;
            maxWeight[current.number] = current.weight; // 지금까지 가지고 온 양 저장

            if (current.number == hyebin) {
                continue;
            }

            for (Target target : bridges.get(current.number)) {
                target.weight = Math.min(current.weight, target.weight); // 가져갈 수 있는 만큼만 가지고
                queue.add(target); // 다음 경로 저장
            }
        }

        bw.write(Integer.toString(maxWeight[hyebin]));
        bw.flush();
    }

    static class Target implements Comparable<Target> {

        int number;
        int weight;

        public Target(final int number, final int weight) {
            this.number = number;
            this.weight = weight;
        }

        @Override
        public int compareTo(final Target o) {
            // queue에서 내림차순 정렬 -> 더 많이 가져갈 수 있는 곳 부터 탐색
            return Integer.compare(o.weight, weight);
        }
    }
}
