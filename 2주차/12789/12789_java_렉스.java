import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Stack;
        import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> previousLine = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            previousLine.add(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> stack = new Stack<>();
        int distributionOrder = 1;

        while (true) {
            if (!previousLine.isEmpty() && previousLine.peek() == distributionOrder) {
                previousLine.poll();
                distributionOrder++;
            } else if (!stack.isEmpty() && stack.peek() == distributionOrder) {
                stack.pop();
                distributionOrder++;
            } else if (!previousLine.isEmpty()) {
                int poll = previousLine.poll();
                stack.add(poll);
            } else {
                break;
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }
    }
}
