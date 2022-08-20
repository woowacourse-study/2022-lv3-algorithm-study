import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int politician, weight;

        public Node(int politician, int weight) {
            this.politician = politician;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

    static int T, N, M;
    static int[][] map;
    static int MAX_VALUE = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            Map<Integer, Integer> result = new HashMap<>(); // 각 노드별 가중치 계산
            Map<Integer, List<Integer>> passBy = new HashMap<>(); // 각 노드가 지나간 길 계산

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 초기값 세팅
            pq.add(new Node(0, 0));

            for (int j = 0; j < M; j++) {
                result.put(j, MAX_VALUE);
                passBy.put(j, new ArrayList<>());
            }
            result.put(0, 0);
            passBy.put(0, List.of(0));

            // map 초기세팅 + 입력
            map = new int[M][M];
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < M; k++) {
                    map[j][k] = MAX_VALUE;
                }
            }

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                map[x][y] = z;
                map[y][x] = z;
            }

            // 다익스트라 알고리즘.
            while (!pq.isEmpty()) {
                Node node = pq.poll();

                // 현재 가중치가 더 작으면 pass.
                if (result.get(node.politician) >= node.weight) {
                    for (int j = 0; j < M; j++) {
                        if (j == node.politician) {
                            continue;
                        }
                        int newWeight = node.weight + map[node.politician][j];
                        if (newWeight < result.get(j)) {
                            result.put(j, newWeight);
                            pq.add(new Node(j, newWeight));

                            List<Integer> tmp = new ArrayList<>(passBy.get(node.politician));
                            tmp.add(j);
                            passBy.put(j, tmp);
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder("Case #")
                .append(i + 1)
                .append(": ");

            if (passBy.get(M - 1).isEmpty()) {
                sb.append(-1);
            } else {
                for (Integer politician : passBy.get(M - 1)) {
                    sb.append(politician).append(" ");
                }
            }

            System.out.println(sb);

        }

    }
}