import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
        int[] students = Arrays.stream(input().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> waiting = new ArrayDeque<>();
        Deque<Integer> temporary = new ArrayDeque<>();

        for (int student : students){
            waiting.addLast(student);
        }

        int sequence = 1;

        while (true) {
            if (!waiting.isEmpty() && waiting.peekFirst() == sequence) {
                waiting.pop();
                sequence++;
            } else if (!temporary.isEmpty() && temporary.peekFirst() == sequence) {
                temporary.pop();
                sequence++;
            } else if (!waiting.isEmpty()) {
                temporary.push(waiting.pop());
            } else {
                break;
            }
        }

        if (temporary.isEmpty() && waiting.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
