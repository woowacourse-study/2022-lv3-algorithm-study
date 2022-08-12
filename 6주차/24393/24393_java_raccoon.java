import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static final int JOKER = 0;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(input());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = JOKER; i <= 26; i++) {
            deque.add(i);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(input());
            Deque<Integer> leftDeque = new ArrayDeque<>();
            Deque<Integer> rightDeque = new ArrayDeque<>();
            for (int j = 0; j < 13; j++) {
                leftDeque.add(deque.pollFirst());
            }
            for (int j = 0; j < 14; j++) {
                rightDeque.add(deque.pollFirst());
            }

            boolean isLeft = false;
            while (tokenizer.hasMoreTokens()) {
                int count = Integer.parseInt(tokenizer.nextToken());
                if (isLeft) {
                    for (int j = 0; j < count; j++) {
                        deque.offer(leftDeque.pollFirst());
                    }
                } else {
                    for (int j = 0; j < count; j++) {
                        deque.offer(rightDeque.poll());
                    }
                }
                isLeft = !isLeft;
            }
        }

        for (int i = 0; i < 27; i++) {
            if (deque.poll() == JOKER) {
                System.out.println(i+1);
                break;
            }
        }
    }
}

