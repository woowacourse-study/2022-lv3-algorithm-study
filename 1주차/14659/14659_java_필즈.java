import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] 한조들 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(str -> Integer.parseInt(str))
                .toArray();

        int maxCount = solve(size, 한조들);

        out.println(maxCount);

        br.close();
    }

    public static int solve(int size, int[] 한조들) {

        int[] counts = new int[size - 1];
        for (int i = 0; i < size - 1; i++) {
            int 한조 = 한조들[i];
            for (int j = i + 1; j < size; j++) {
                if (한조 > 한조들[j]) {
                    counts[i]++;
                } else {
                    break;
                }
            }
        }

        int maxCount = Arrays.stream(counts)
                .max()
                .getAsInt();

        return maxCount;
    }
}
