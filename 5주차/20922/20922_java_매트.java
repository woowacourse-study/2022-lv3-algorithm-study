import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = 0;
        int start = 0;
        int end = 0;
        int[] count = new int[n + 1];
        while (end < numbers.length) {
            while (end < numbers.length && count[numbers[end]] < k) {
                count[numbers[end]]++;
                end++;
            }

            int length = end - start;
            result = Math.max(result, length);
            count[numbers[start]] -= 1;
            start++;
        }

        System.out.println(result);
    }
}
