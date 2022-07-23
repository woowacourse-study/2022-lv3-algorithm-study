package algorithm_study.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class java_13702_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> quantities = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            quantities.add(Integer.parseInt(br.readLine()));
        }

        int min = 1;
        int max = Integer.MAX_VALUE;
        int maxNum = 0;

        while (min <= max) {
            int pivot = min + (max - min) / 2;
            int count = quantities.stream()
                .mapToInt(quantity -> quantity / pivot)
                .sum();

            if (count >= K) {
                maxNum = pivot;
                min = pivot + 1;
            } else {
                max = pivot - 1;
            }
        }
        System.out.println(maxNum);
    }
}
