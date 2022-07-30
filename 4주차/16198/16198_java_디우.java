import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

class Main16198 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static int result = 0;

    public static void main(String[] args) throws IOException {
        final String count = reader.readLine();
        final List<Integer> numbers = getNumbers();

        dfs(0, numbers);

        System.out.println(result);
    }

    private static void dfs(int sum, List<Integer> numbers) {
        if (numbers.size() <= 2) {
            result = Math.max(sum, result);
            return;
        }

        for (int i = 1; i < numbers.size() - 1; i++) {
            final int buffer = numbers.get(i - 1) * numbers.get(i + 1);
            final int number = numbers.get(i);
            numbers.remove(i);
            dfs(sum + buffer, numbers);
            numbers.add(i, number);
        }
    }

    private static List<Integer> getNumbers() throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(toList());
    }
}
