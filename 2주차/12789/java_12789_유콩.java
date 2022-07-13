import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        br.readLine();
        Queue<Integer> lines = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            lines.add(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> delays = new Stack<>();
        int current;
        int received = 1;

        while (!lines.isEmpty()) {
            current = lines.peek();
            if (current == received) {
                lines.poll();
                received++;
            } else {
                delays.push(lines.poll());
            }

            while (!delays.isEmpty()) {
                current = delays.peek();
                if (current == received) {
                    delays.pop();
                    received++;
                } else {
                    break;
                }
            }
        }

        if (delays.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
