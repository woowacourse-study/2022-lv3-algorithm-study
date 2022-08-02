import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            Integer pushedHeight = stack.push(scanner.nextInt());

            // 해당 건물 높이보다 같거나 작은 경우 삭제 처리한다.
            while (!stack.isEmpty() && stack.peek() <= pushedHeight) {
                stack.pop();
            }

            result += stack.size();
            stack.push(pushedHeight);
        }

        System.out.println(result);
    }
}
