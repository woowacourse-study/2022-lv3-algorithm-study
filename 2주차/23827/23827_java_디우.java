import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

class Main23827 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int size = Integer.parseInt(reader.readLine());
        final List<Integer> numbers = readNumbers();

        long sum = 0;
        for (int i = 0; i < size; i++) {
            final int number = numbers.get(i);
            sum = sum + number;
        }

        long result = 0;
        for (int i = size - 1; i > 0; i--) {
            final int standard = numbers.get(i);

            sum = sum - standard;

            result = (result + (standard * sum)) % 1_000_000_007;
        }

        System.out.print(result);
    }

    private static List<Integer> readNumbers() throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(toList());
    }
}
