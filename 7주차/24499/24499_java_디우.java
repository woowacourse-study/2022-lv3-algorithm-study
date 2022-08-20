import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

class Main24499 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final List<Integer> numbers = getNumbers();
        int eatingCount = numbers.get(1);

        final List<Integer> applePies = getNumbers();

        final List<Integer> additionalApplePies = applePies.subList(0, eatingCount);
        applePies.addAll(additionalApplePies);

        int max = 0;
        int sum = 0;

        for (int i = 0; i < eatingCount; i++) {
            sum += applePies.get(i);
        }

        for (int i = 0; i < applePies.size() - eatingCount; i++) {
            sum = sum - applePies.get(i) + applePies.get(i + eatingCount);
            max = Math.max(sum, max);
        }

        System.out.print(max);
    }

    private static List<Integer> getNumbers() throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(toList());
    }
}
