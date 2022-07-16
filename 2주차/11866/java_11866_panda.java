package algorithm_study.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class java_11866_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        int pivot = 0;
        while (!numbers.isEmpty()) {
            pivot = (pivot - 1 + K) % numbers.size();
            sb.append(numbers.remove(pivot)).append(", ");
        }
        System.out.println(sb.substring(0, sb.length() - 2) + ">");
    }
}

