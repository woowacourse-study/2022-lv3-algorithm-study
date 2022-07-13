import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        Queue<Integer> qu = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            qu.add(Integer.parseInt(inputs[i]));
        }

        //알고리즘
        int cnt = 1;
        while (!qu.isEmpty()) {
            int cur1 = qu.peek();
            if (cur1 == cnt) {
                cnt++;
                qu.poll();
                continue;
            }

            while (!stack.isEmpty()) {
                int cur2 = stack.peek();
                if (cur2 == cnt) {
                    cnt++;
                    stack.pop();
                    continue;
                }

                break;
            }

            stack.push(qu.poll());
        }

        while (!stack.isEmpty()) {
            int cur = stack.peek();
            if (cur == cnt) {
                cnt++;
                stack.pop();
                continue;
            }

            break;
        }

        //출력
        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
