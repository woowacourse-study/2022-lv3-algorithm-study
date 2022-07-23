import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// DFS 시간 초과
public class Main {

    /*
     * N: 정거장 개수
     * M: 텔레포트 정보 개수
     * S: 출발 위치
     * E: 도착 위치
     */
    private static int N, M, S, E;
    private static final Map<Integer, Set<Integer>> teleports = new HashMap<>();
    private static boolean[] visited;
    private static int min;

    public static void main(String[] args) throws IOException {
        input();
        visited[S] = true;
        calculate(0, S);
        System.out.println(min);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = N;
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            putValue(x, y);
            putValue(y, x);
        }

        br.close();
    }

    private static void putValue(int x, int y) {
        Set<Integer> value = teleports.getOrDefault(x, new HashSet<>());
        value.add(y);
        teleports.put(x, value);
    }

    private static void calculate(int sum, int now) {
        if (now == E) {
            min = Math.min(min, sum);
            return;
        }

        if (now - 1 > 0 && !visited[now - 1]) {
            visited[now - 1] = true;
            calculate(sum + 1, now - 1);
            visited[now - 1] = false;
        }

        if (now + 1 <= N && !visited[now + 1]) {
            visited[now + 1] = true;
            calculate(sum + 1, now + 1);
            visited[now + 1] = false;
        }

        for (int n : teleports.getOrDefault(now, new HashSet<>())) {
            if (!visited[n]) {
                visited[n] = true;
                calculate(sum + 1, n);
                visited[n] = false;
            }
        }
    }
}
