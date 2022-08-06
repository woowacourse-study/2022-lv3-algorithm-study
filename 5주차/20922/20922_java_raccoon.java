import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        String[] temp = input().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);
        int[] numbers = Arrays.stream(input().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] counting = new int[100001];

        for (int number : numbers) {
            deque.offer(number);
            counting[number] += 1;
            if (counting[number] > k) {
                while (!deque.isEmpty() && (--counting[deque.poll()]) != k);
            }
            answer = Math.max(answer, deque.size());
        }

        System.out.println(answer);
    }
}
