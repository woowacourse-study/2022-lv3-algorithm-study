import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final Stack<Integer> waiting = new Stack<>();
    private static int passNumber = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (number == passNumber) {
                passNumber++;
                continue;
            }
            checkWaiting();
            waiting.push(number);
        }

        checkWaiting();

        printResult(waiting.isEmpty());
        bf.close();
    }

    private static void checkWaiting() {
        while (!waiting.isEmpty() && waiting.peek() == passNumber) {
            passNumber++;
            waiting.pop();
        }
    }

    private static void printResult(boolean condition) {
        if (condition) {
            System.out.println("Nice");
            return;
        }
        System.out.println("Sad");
    }
}
