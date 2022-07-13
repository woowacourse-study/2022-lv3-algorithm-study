import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class java_12789_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> waitingLine = new Stack<>();
        waitingLine.push(N+2);
        int current = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            waitingLine.push(Integer.parseInt(st.nextToken()));
            while (waitingLine.peek() == current) {
                waitingLine.pop();
                current++;
            }
        }
        System.out.println(current > N ? "Nice" : "Sad");
    }
}
