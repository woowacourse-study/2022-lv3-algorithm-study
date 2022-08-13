import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Kun_24499 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> pies = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pies.add(Integer.parseInt(st.nextToken()));
        }

        long sum = 0;
        for (int i = 0; i < K; i++) {
            sum += pies.get(i);
        }

        long max = sum;
        for (int i = K; i < N + K; i++) {
            sum += (pies.get(i % N) - pies.get(i - K));
            max = Math.max(max, sum);
        }
        System.out.println(max);

    }
}
