package boj.p12789;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int turn = 1;
        for (int i = 0; i < N; i++) {
            if (arr[i] != turn) {
                if (!stack.isEmpty() && stack.peek() == turn) {
                    stack.pop();
                    i--;
                    turn++;
                } else {
                    stack.push(arr[i]);
                }
            } else {
                turn++;
            }
        }

        String result = calculate(stack, turn);
        bw.write(result);
        bw.flush();

        br.close();
        bw.close();
    }

    private static String calculate(Stack<Integer> stack, int turn) {
        for (int i = 0; i < stack.size(); i++) {
            if (stack.peek() != turn) {
                return "Sad";
            } else {
                stack.pop();
                turn++;
            }
        }
        return "Nice";
    }
}
