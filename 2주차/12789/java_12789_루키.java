import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class java_12789_루키 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> line = new LinkedList<>();
        while (st.hasMoreTokens()) {
            line.add(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> waiting_line = new Stack<>();

        int number = 1;
        while (true) {
            if (!line.isEmpty() && line.peek() == number) {
                line.poll();
                number++;
            }
            else if (!waiting_line.isEmpty() && waiting_line.peek() != number) {
                waiting_line.pop();
                number++;
            }
            else if (!line.isEmpty()) {
                waiting_line.push(line.poll());
            }
            else {
                break;
            }
        }

        if (number == count + 1) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
