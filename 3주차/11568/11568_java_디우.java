import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main11568 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int count = Integer.parseInt(reader.readLine());
        final int[] numbers = extractNumbers();

        List<Integer> result = new ArrayList<>();

        result.add(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            final Integer max = Collections.max(result);
            if (numbers[i] > max) {
                result.add(numbers[i]);
                continue;
            }
            for (int j = 0; j < result.size(); j++) {
                if (result.get(j) >= numbers[i]) {
                    result.remove(j);
                    result.add(j, numbers[i]);
                    break;
                }
            }
        }

        System.out.println(result.size());
    }

    private static int[] extractNumbers() throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
