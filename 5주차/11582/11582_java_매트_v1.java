import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        List<Integer> numbers = Arrays.stream(bufferedReader.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        int k = Integer.parseInt(bufferedReader.readLine());

        List<Integer> sortedNumbers = new ArrayList<>();
        for (int i = 0; i < n; i += (n / k)) {
            List<Integer> subNumbers = numbers.subList(i, i + (n / k));
            subNumbers.sort(Comparator.naturalOrder());
            sortedNumbers.addAll(subNumbers);
        }

        String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
