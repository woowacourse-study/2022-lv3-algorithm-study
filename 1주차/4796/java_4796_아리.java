import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;

        while (true) {
            String input = br.readLine();

            if ("0 0 0".equals(input)) {
                break;
            }

            solve(input, count);

            count++;
        }
    }

    private static void solve(String input, int count) {
        String[] arr = input.split(" ");

        int L = Integer.parseInt(arr[0]);
        int P = Integer.parseInt(arr[1]);
        int V = Integer.parseInt(arr[2]);

        int result = V / P * L + Math.min(L, V % P);
        System.out.println("Case " + count + ": " + result);
    }
}
