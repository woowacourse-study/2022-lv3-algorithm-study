import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int totalCount = 1;

        while (true) {
            final String input = reader.readLine();

            if (input.equals("0 0 0")) {
                break;
            }

            final int[] inputs = getInputs(input);
            final int possibleDays = calculatePossibleDays(inputs);

            System.out.println("Case " + totalCount + ": " + possibleDays);

            totalCount++;
        }
    }

    private static int[] getInputs(String input) {
        return Arrays.stream(input.split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private static int calculatePossibleDays(int[] inputs) {
        final int count = inputs[2] / inputs[1];
        final int days = count * inputs[0];
        final int remainingDays = Math.min(inputs[2] % inputs[1], inputs[0]);

        return days + remainingDays;
    }
}
