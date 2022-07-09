import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int index = 1;
        String input = br.readLine();
        while (!input.equals("0 0 0")) {
            calculate(index++, input);
            input = br.readLine();
        }
        br.close();
        System.out.println(sb);
    }

    private static void calculate(int n, String input) {
        int[] arr = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        sb.append("Case ")
                .append(n)
                .append(": ")
                .append((arr[2] / arr[1]) * arr[0] + Math.min(arr[0], arr[2] % arr[1]))
                .append("\n");
    }
}
