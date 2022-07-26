package algorithm_study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class java_20922_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        Queue<Integer> sub = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sub.add(num);
            int count = counts.getOrDefault(num, 0);
            counts.put(num, ++count);
            if (count > K) {
                int head = sub.poll();
                while (head != num) {
                    counts.replace(head, counts.get(head) - 1);
                    head = sub.poll();
                }
                counts.replace(num, K);
            }
            max = Math.max(sub.size(), max);
        }
        System.out.println(max);
    }
}
