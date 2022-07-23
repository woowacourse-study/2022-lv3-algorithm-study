import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main12702 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int[] inputs = getInputs();
        final int cupCount = inputs[0];
        final int memberSize = inputs[1];

        int min = 0;
        int max = 0;

        List<Integer> volumes = new ArrayList<>();
        for (int i = 0; i < cupCount; i++) {
            final int volume = Integer.parseInt(reader.readLine());
            volumes.add(volume);
            if (max < volume) {
                max = volume;
            }
        }

        while (min <= max) {
            int count = 0;
            final int middle = (min + max) / 2;

            for (Integer volume : volumes) {
                count = count + (volume / middle);
            }

            if (count >= memberSize) {
                min = middle + 1;
            }
            if (count < memberSize) {
                max = middle - 1;
            }
        }

        System.out.print(max);
    }

    private static int[] getInputs() throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
