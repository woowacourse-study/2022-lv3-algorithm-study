import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(calculate(inputs, n));
    }

    private static int calculate(int[] inputs, int length) {
        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < length; i++) {
            if(inputs[i] < inputs[maxIndex]) {
                continue;
            }

            int count = 0;
            for (int j = i + 1; j < length; j++) {
                if (inputs[i] < inputs[j]) {
                    break;
                }
                if (inputs[i] > inputs[j]) {
                    count++;
                }
            }
            if(max < count) {
                max = count;
                maxIndex = i;
            }
        }

        return max;
    }
}
