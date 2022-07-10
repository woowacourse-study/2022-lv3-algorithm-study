import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class josh_java_12789 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        List<Integer> bucket = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int currentOrder = 1;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(1001);

        String answer = "Nice";
        while (!isEnd(bucket, index) || !isStackEmpty(stack)) {
            int element = getElement(bucket, index);
            if (element == currentOrder) {
                currentOrder += 1;
                index += 1;
            } else if (stack.peek() == currentOrder) {
                stack.pop();
                currentOrder += 1;
            } else if (element < stack.peek()) {
                stack.push(element);
                index += 1;
            } else {
                answer = "Sad";
                break;
            }
        }

        System.out.println(answer);
    }

    private static int getElement(List<Integer> bucket, int index) {
        if (isEnd(bucket, index)) {
            return 2000;
        }
        return bucket.get(index);
    }

    private static boolean isStackEmpty(Stack<Integer> stack) {
        return stack.peek() == 1001;
    }

    private static boolean isEnd(List<Integer> bucket, int index) {
        return bucket.size() == index;
    }
}
