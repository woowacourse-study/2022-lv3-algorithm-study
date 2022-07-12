import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Kun_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            que.offer(Integer.parseInt(st.nextToken()));
        }
        Stack<Integer> stk = new Stack<>();

        int count = 1;
        while (count <= n) {
            if (!que.isEmpty()) {
                int temp = que.peek();
                if (temp == count) {
                    count++;
                    que.poll();
                } else if (!stk.isEmpty() && (stk.peek() == count)) {
                    stk.pop();
                    count++;
                } else {
                    stk.push(temp);
                    que.poll();
                }
            } else if (!stk.isEmpty()) {
                if (count == stk.peek()) {
                    stk.pop();
                    count++;
                } else {
                    break;
                }
            }
        }

        if (stk.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }

    }
}
