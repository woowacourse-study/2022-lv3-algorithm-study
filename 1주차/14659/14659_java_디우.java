import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main14659 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int count = Integer.parseInt(reader.readLine());
        final List<Integer> numbers = initNumbers();

        int max = numbers.get(0);
        List<Integer> buffer = new ArrayList<>();
        int result = 0;
        buffer.add(result);

        for (Integer number : numbers) {
            if (number > max) {
                max = number;
                buffer.add(result);
                result = 0;
            }
            if (number < max) {
                result++;
            }
        }

        buffer.add(result);

        System.out.println(Collections.max(buffer));
    }

    private static List<Integer> initNumbers() throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(toList());
    }
}
