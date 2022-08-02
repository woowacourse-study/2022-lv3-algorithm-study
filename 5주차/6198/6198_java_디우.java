import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main6198 {

    final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final int count = Integer.parseInt(reader.readLine());

        long[] buildings = new long[count];

        for (int i = 0; i < count; i++) {
            final int number = Integer.parseInt(reader.readLine());
            buildings[i] = number;
        }

        long result = 0;

        for (int i = 0; i < count; i++) {
            long number = buildings[i];

            for (int j = i + 1; j < count; j++) {
                long buf = buildings[j];

                if (number > buf) {
                    result ++;
                } else {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
