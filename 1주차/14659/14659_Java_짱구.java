import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine()
                .split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int result = 0;
        int num = arr[0];
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (num < arr[i]) {
                result = Math.max(result, count);
                num = arr[i];
                count = 0;
                continue;
            }
            count++;
        }

        result = Math.max(result, count);
        System.out.println(result);
    }
}