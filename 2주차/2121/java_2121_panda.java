package algorithm_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class java_2121_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Map<Integer, Set<Integer>> points = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points.computeIfAbsent(x, k -> new HashSet<>());
            points.get(x).add(y);
        }

        int answer = 0;
        for (int x : points.keySet()) {
            if (!points.containsKey(x + A)) {
                continue;
            }
            Set<Integer> yCoords = points.get(x);
            for (int y : yCoords) {
                if (yCoords.contains(y + B)
                    && points.get(x + A).containsAll(Set.of(y, y + B))) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
