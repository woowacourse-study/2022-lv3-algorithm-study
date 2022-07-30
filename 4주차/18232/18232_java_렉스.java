import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, S, E;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1]; // 해당 지점을 방문한 적이 있는지 체크하는 필드
        Map<Integer, List<Integer>> teleportInfo = new HashMap<>(); // 각 지점별로 연결된 텔레포트 정보를 저장하는 필드

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            teleportInfo.putIfAbsent(x, new ArrayList<>());
            teleportInfo.get(x).add(y);
            teleportInfo.putIfAbsent(y, new ArrayList<>());
            teleportInfo.get(y).add(x);
        }

        System.out.println(bfs(teleportInfo));
    }

    private static int bfs(Map<Integer, List<Integer>> teleportInfo) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        int move = 0;
        while (!queue.isEmpty()) {

            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int polled = queue.poll();

                if (polled == E) {
                    return move;
                }

                visited[polled] = true;
                if (1 <= (polled - 1) && !visited[polled - 1]) { // X-1 번째 위치 추가
                    queue.offer(polled - 1);
                }
                if ((polled + 1) <= N && !visited[polled + 1]) { // X+1 번째 위치 추가
                    queue.offer(polled + 1);
                }
                // 연결된 텔레포트로 갈 수 있는 위치 추가
                if (teleportInfo.containsKey(polled)) {
                    for (int position : teleportInfo.get(polled)) {
                        if (!visited[position]) {
                            queue.offer(position);
                        }
                    }
                }
            }
            move++;
        }
        return 0;
    }
}
