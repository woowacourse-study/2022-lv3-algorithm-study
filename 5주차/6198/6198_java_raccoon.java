import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

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
        long answer = 0;
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(input());
            while (!deque.isEmpty() && deque.peekFirst() <= height) {
                deque.pollFirst();
            }
            answer += deque.size();
            deque.offerFirst(height);
        }

        System.out.println(answer);
    }
}
