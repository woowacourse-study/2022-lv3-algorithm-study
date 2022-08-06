package algorithm_study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class java_16432_panda {
    static int N;
    static int[] picked;
    static List<Integer>[] cakes;
    static boolean[][] visited;
    static boolean succeed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        picked = new int[N];
        visited = new boolean[N][];

        cakes = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            visited[i] = new boolean[m];
            cakes[i] = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                cakes[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        doDFS(0, 0);

        StringBuilder answer = new StringBuilder();
        if (succeed) {
            Arrays.stream(picked).forEachOrdered(it -> answer.append(it).append("\n"));
        } else {
            answer.append(-1);
        }
        System.out.println(answer);
    }

    private static void doDFS(int day, int last) {
        if (day == N) {
            succeed = true;
            return;
        }

        for (int cake : cakes[day]) {
            if (cake == last) continue;
            int index = cakes[day].indexOf(cake);
            if (visited[day][index]) continue;

            visited[day][index] = true;
            picked[day] = cake;
            doDFS(day + 1, cake);
            if (succeed) return;
        }
    }
}
