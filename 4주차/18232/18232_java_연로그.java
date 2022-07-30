import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
     * N: 정거장 개수
     * M: 텔레포트 정보 개수
     * S: 출발 위치
     * E: 도착 위치
     */
    private static int N, M, S, E;
    private static boolean[] visited;
    private static final Map<Integer, Set<Integer>> teleports = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(calculate());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            teleports.computeIfAbsent(x, it -> new HashSet<>()).add(y);
            teleports.computeIfAbsent(y, it -> new HashSet<>()).add(x);
        }

        br.close();
    }

    private static int calculate() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{S, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int link : findLinks(now[0])) {
                if (visited[link]) {
                    continue;
                }

                if (link == E) {
                    return now[1] + 1;
                }

                visited[link] = true;
                q.add(new int[]{link, now[1] + 1});
            }
        }

        return 0;
    }

    private static Set<Integer> findLinks(int now) {
        Set<Integer> links = teleports.getOrDefault(now, new HashSet<>());
        if (now - 1 > 0) {
            links.add(now - 1);
        }
        if (now + 1 <= N) {
            links.add(now + 1);
        }
        return links;
    }
}
