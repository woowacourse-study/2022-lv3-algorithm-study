import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        String[] temp = input().split(" ");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);

        List<Integer> pots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pots.add(Integer.parseInt(input()));
        }

        long left = 1;
        long right = Integer.MAX_VALUE;
        long answer = -1;

        while (left <= right) {
            long mid = (left + right) / 2;
            long personCount = 0;

            for (int pot : pots) {
                personCount += (pot / mid);
            }

            if (personCount >= k) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
