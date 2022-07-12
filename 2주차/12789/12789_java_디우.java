import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class Main12789 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int max = 1;

        final int count = Integer.parseInt(reader.readLine());

        final List<Integer> numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < count; i++) {
            final int number = numbers.get(i);

            if (number == max) {
                max = max + 1;
            } else {
                stack.push(number);
            }

            while (!stack.isEmpty() && stack.peek() == max) {
                stack.pop();
                max = max + 1;
            }
        }

        max = max - 1;

        if (max == count) {
            System.out.println("Nice");
        }
        if (max != count) {
            System.out.println("Sad");
        }
    }
}
