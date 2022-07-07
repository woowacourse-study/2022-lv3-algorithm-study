import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> previousLine = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            previousLine.add(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> stack = new Stack<>();
        boolean isSuccess = true;
        int distributionOrder = 1;
        for (int order : previousLine) {
            if (distributionOrder == order) {
                distributionOrder++;
            } else if (!stack.isEmpty() && stack.peek() < order) {
                isSuccess = false;
                break;
            } else {
                stack.add(order);
            }

            while (!stack.isEmpty() && stack.peek() == distributionOrder) {
                stack.pop();
                distributionOrder++;
            }
        }

        if (isSuccess) System.out.println("Nice");
        else System.out.println("Sad");
    }
}
