package boj.p11866;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int count = 1;
        while (!queue.isEmpty()) {
            int front = queue.peek();
            if (count % K == 0) {
                result.add(queue.peek());
                queue.poll();
            } else {
                queue.add(front);
                queue.poll();
            }
            count++;
        }

        List<String> resultToString = result.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        String output = String.join(", ", resultToString);

        sb.append("<")
                .append(output)
                .append(">");

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
