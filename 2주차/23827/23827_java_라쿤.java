import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static final int DIVISOR = 1000000007;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input() {
        try {
            return reader.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(input());
        long[] arr = Arrays.stream(input().split(" "))
                .mapToLong(Long :: parseLong)
                .toArray();

        long sum = Arrays.stream(arr).sum();

        long answer = 0;
        for (int i = 0; i < arr.length; i++) {
            answer += (sum - arr[i]) * arr[i];
            answer %= DIVISOR;
            sum = sum - arr[i];
        }

        System.out.println(answer);
    }
}
