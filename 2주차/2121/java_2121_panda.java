package algorithm_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class java_2121_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> points = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points.computeIfAbsent(x, k -> new ArrayList<>());
            points.get(x).add(y);
        }

        int answer = 0;
        for (int x : points.keySet()) {
            if (!points.containsKey(x + A)) {
                continue;
            }
            for (int y : points.get(x)) {
                if (points.get(x).contains(y + B)
                    && points.get(x + A).containsAll(List.of(y, y + B))) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
