import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(calculate(Integer.parseInt(br.readLine())));
    }

    private static char calculate(int N) {
        if (N == 1) {
            return 'm';
        }
        if (N <= 3) {
            return 'o';
        }

        int length = 3;
        int count = 0;

        while (length < N) {
            count++;
            length = length * 2 + count + 3;
        }

        int middleStart = (length - count - 3) / 2 + 1;
        if (middleStart == N) {
            return 'm';
        }
        if (middleStart + count + 2 >= N) {
            return 'o';
        }
        return calculate(N - middleStart - count - 2);
    }
}
