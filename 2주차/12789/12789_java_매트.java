import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int index = 1;
        int n = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }

        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            // 현재 줄 서 있는 공간에서 peek 후 순서 비교
            if (index == queue.peek()) {
                index++;
                queue.poll();
                continue;
            }

            // 한 명씩만 설 수 있는 공간에 사람이 존재한다면 peek 후 순서 비교
            if (!stack.isEmpty() && index == stack.peek()) {
                index++;
                stack.pop();
                continue;
            }

            stack.push(queue.poll());
        }

        // 한 명씩만 설 수 있는 공간에 남은 사람들에게 간식 배부가 가능한지 확인
        while (!stack.isEmpty()) {
            if (stack.peek() != index) {
                System.out.println("Sad");
                return;
            }

            stack.pop();
            index++;
        }

        System.out.println("Nice");
    }
}
