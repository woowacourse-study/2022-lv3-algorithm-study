import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

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
        int[] sequences = Arrays.stream(input().split(" "))
                .mapToInt(Integer :: parseInt)
                .toArray();
        int[] dp = new int[sequences.length];

        for (int i = 0; i < sequences.length; i++) {
            int lastMaxCount = 0;
            for (int j = 0; j < i; j++) {
                if (sequences[j] < sequences[i]) {
                    lastMaxCount = Math.max(lastMaxCount, dp[j]);
                }
            }

            dp[i] = lastMaxCount + 1;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
