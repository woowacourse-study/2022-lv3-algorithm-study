import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] buildings = new long[N];
        for (int i = 0; i < N; i++) {
            buildings[i] = Long.parseLong(br.readLine());
        }
        br.close();

        // calculate
        long sum = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (buildings[i] <= buildings[j]) {
                    break;
                }
                sum++;
            }
        }
        System.out.println(sum);
    }

}
