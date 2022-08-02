import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int height = stack.push(Integer.parseInt(br.readLine()));

            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }
            result += stack.size();
            stack.push(height);
        }

        System.out.println(result);
    }
}
