import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    // 구글의 도움을 받았습니다ㅠㅠ
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        long result = 0;
        while (N > 0) {
            int height = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }
            result += stack.size();
            stack.push(height);
            N--;
        }
        System.out.println(result);
    }
}
