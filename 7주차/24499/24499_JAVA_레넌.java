package boj.p24499;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> tasty = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tasty.add(Integer.parseInt(st.nextToken()));
        }

        tasty.addAll(tasty.subList(0, K - 1));

        int max = tasty.subList(0, K).stream()
                .mapToInt(Integer::intValue)
                .sum();
        int prior = max;
        for (int i = 0; i < tasty.size() - K; i++) {
            int sum = prior - tasty.get(i) + tasty.get(K + i);
            prior = sum;
            max = Integer.max(max, sum);
        }
        bw.write(max + "");
        bw.flush();

        br.close();
        bw.close();
    }
}
