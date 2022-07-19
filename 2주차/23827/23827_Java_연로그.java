import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // ❗ 누적합이라는 개념을 처음 들어서 찾아보고 풀었습니다

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        long result = 0;
        long sum = 0;
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            long number = Long.parseLong(st.nextToken());
            result += number * sum;
            result %= 1_000_000_007;
            sum += number;
        }

        System.out.println(result);
        bf.close();
    }
}
