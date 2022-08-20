package algorithm_study.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class java_16288_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        TreeSet<Integer> queueTop = new TreeSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int exit = Integer.parseInt(st.nextToken());
            Integer integer = queueTop.lower(exit);

            if (Objects.nonNull(integer)) {
                queueTop.remove(integer);
            }
            queueTop.add(exit);
        }
        System.out.println(K >= queueTop.size() ? "YES" : "NO");
    }
}
