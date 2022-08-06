package algorithm_study.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class java_6198_panda {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            while (stack.peek() <= height) {
                stack.pop();
            }
            sum += stack.size();
            stack.push(height);
        }
        System.out.println(sum);
    }
}
