package algorithm_study.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class java_25391_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<int[]> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            students.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        long sum = 0;

        students.sort((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < K; i++) {
            sum += students.remove(0)[0];
        }

        students.sort((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < M; i++) {
            sum += students.get(i)[0];
        }

        System.out.println(sum);
    }
}

