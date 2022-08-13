import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= 27; i++) {
            deque.add(i);
        }
        for (int i = 0; i < N; i++) {
            Deque<Integer> leftDeque = new ArrayDeque<>();
            Deque<Integer> rightDeque = new ArrayDeque<>();
            for (int j = 0; j < 13; j++) {
                leftDeque.add(deque.pollFirst());
            }
            for (int j = 0; j < 14; j++) {
                rightDeque.add(deque.pollFirst());
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean flag = false;
            while (st.hasMoreTokens()) {
                int changeCount = Integer.parseInt(st.nextToken());
                if (!flag) {
                    for (int j = 0; j < changeCount; j++) {
                        deque.add(rightDeque.poll());
                    }
                } else {
                    for (int j = 0; j < changeCount; j++) {
                        deque.add(leftDeque.pollFirst());
                    }
                }
                flag = !flag;
            }
        }
        System.out.println(findJoker(deque));
    }

    private static int findJoker(Deque<Integer> deque) {
        for (int i = 1; i <= 27; i++) {
            if (deque.pollFirst() == 1) {
                return i;
            }
        }
        return -1;
    }
}
