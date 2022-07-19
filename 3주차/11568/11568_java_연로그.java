import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        calculate(n, numbers);
        br.close();
    }

    private static void calculate(int n, int[] numbers) {
        int[] counts = new int[n];
        Arrays.fill(counts, 1);
        int max = counts[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    counts[i] = Math.max(counts[i], counts[j] + 1);
                }
            }
            max = Math.max(counts[i], max);
        }
        System.out.println(max);
    }
}
