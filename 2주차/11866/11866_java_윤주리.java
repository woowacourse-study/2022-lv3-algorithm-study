package PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int K = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            queue.offer(i + 1);
        }

        String s = "<";
        int count = 1;
        while (!queue.isEmpty()) {
            if (count == K) {
                s += queue.poll()+ (", ");
                count = 1;
            } else {
                queue.offer(queue.poll());
                count++;
            }
        }
        s = s.substring(0, s.length() - 2);
        s += ">";
        System.out.println(s);
    }
}
