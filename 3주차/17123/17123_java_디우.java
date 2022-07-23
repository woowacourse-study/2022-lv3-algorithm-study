import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main17123 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    final static StringBuffer result = new StringBuffer();

    public static void main(String[] args) throws IOException {
        final int testCase = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCase; i++) {
            int[] inputs = splitInputs();
            int N = inputs[0];
            int M = inputs[1];

            int[] rowSum = new int[N];
            int[] colSum = new int[N];

            for (int j = 0; j < N; j++) {
                final int[] numbers = splitInputs();
                final int sum = Arrays.stream(numbers).sum();

                rowSum[j] = sum;
                for (int k = 0; k < numbers.length; k++) {
                    colSum[k] += numbers[k];
                }
            }

            for (int j = 0; j < M; j++) {
                final int[] command = splitInputs();
                int r1 = command[0] - 1;
                int c1 = command[1] - 1;
                int r2 = command[2] - 1;
                int c2 = command[3] - 1;
                int v = command[4];

                for (int k = 0; k < rowSum.length; k++) {
                    if (r1 <= k && k <= r2) {
                        rowSum[k] += (c2 - c1 + 1) * v;
                    }
                }
                for (int k = 0; k < colSum.length; k++) {
                    if (c1 <= k && k <= c2) {
                        colSum[k] += (r2 - r1 + 1) * v;
                    }
                }
            }
            for (final int k : rowSum) {
                result.append(k + " ");
            }
            result.append("\n");


            for (final int k : colSum) {
                result.append(k + " ");
            }
            result.append("\n");
        }

        System.out.print(result);
    }

    private static int[] splitInputs() throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
