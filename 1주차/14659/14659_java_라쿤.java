import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        int answer = 0;
        int n = Integer.parseInt(input());
        int[] datas = Arrays.stream(input().split(" "))
                .mapToInt(Integer :: parseInt)
                .toArray();

        int left = 0;
        int right = 1;
        while (left <= right && right < n) {
            if (datas[left] < datas[right]) {
                answer = Math.max(answer, right - left - 1);
                left = right;
                right = left;
            }
            right++;
        }
        answer = Math.max(answer, right - left - 1);

        System.out.println(answer);
    }
}
