import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> currentLine = new LinkedList<>();
        for (int i = 0; i < total; i++) {
            currentLine.add(Integer.parseInt(st.nextToken()));
        }

        int currentOrder = 1;
        Stack<Integer> waitingLine = new Stack<>();
        while (true) {
            int popped;
            if (!waitingLine.isEmpty()) {
                popped = waitingLine.pop();
                if (popped == currentOrder) {
                    currentOrder++;
                    continue;
                }
                waitingLine.add(popped);
            }

            if (currentLine.isEmpty()) {
                break;
            }

            while (!currentLine.isEmpty()) {
                popped = currentLine.pop();
                if (popped == currentOrder) {
                    currentOrder++;
                    break;
                }
                waitingLine.add(popped);
            }
        }

        if (currentOrder > total) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
