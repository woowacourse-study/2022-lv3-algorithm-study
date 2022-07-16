import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sum += arr[i];
        }

        long result = 0;
        for (long i : arr) {
            sum -= i;
            result += (i * sum) % 1_000_000_007;
        }

        System.out.println(result % 1_000_000_007);
    }
}