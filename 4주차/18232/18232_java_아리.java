import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Map<Integer, Set<Integer>> map = new HashMap<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Set<Integer> setX = map.getOrDefault(x, new HashSet<>());
            setX.add(y);
            map.put(x, setX);

            Set<Integer> setY = map.getOrDefault(y, new HashSet<>());
            setY.add(x);
            map.put(y, setY);
        }

        Queue<Integer> queue = new LinkedList();
        int[] distance = new int[N + 1];
        queue.add(S);

        while (!queue.isEmpty()) {
            int X = queue.poll();
            int dist = distance[X] + 1;

            Set<Integer> set = map.getOrDefault(X, new HashSet<>());

            // 도착!
            if (X + 1 == E || X - 1 == E || set.contains(E)) {
                System.out.println(dist);
                return;
            }

            // 범위 안에 있고 방문하지 않았다면 방문하고 큐에 넣기
            if (X + 1 <= N && distance[X + 1] == 0) {
                distance[X + 1] = dist;
                queue.add(X + 1);
            }

            if (X - 1 > 0 && distance[X - 1] == 0) {
                distance[X - 1] = dist;
                queue.add(X - 1);
            }

            for (int i : set) {
                if (distance[i] == 0) {
                    distance[i] = dist;
                    queue.add(i);
                }
            }

        }

    }
}
