import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main20922 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int[] inputs = getNumbers();

        int totalLength = inputs[0];
        int max = inputs[1];

        int[] numbers = getNumbers();
        int[] bufCount = new int[numbers.length];

        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            final int number = numbers[i];
            bufCount[number - 1] ++;
            final int buf = bufCount[number - 1];
            if (buf > max) {
                result = i;
            }
        }
        System.out.print(result);
    }

    private static int[] getNumbers() throws IOException {
        return Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
