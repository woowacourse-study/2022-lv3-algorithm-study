import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        String[] ss = bufferedReader.readLine().split(" ");
        List<Integer> numbers = Arrays.stream(ss)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = getResult(numbers);
        System.out.println(result);
    }

    public static int getResult(List<Integer> numbers) {
        int result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int count = 0;
            Integer now = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                if (now > numbers.get(j)) {
                    count += 1;
                } else {
                    break;
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
