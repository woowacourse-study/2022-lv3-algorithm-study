import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] counts = new int[100_001];
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < numbers.length) {
            if (counts[numbers[end]] < K) {
                // 개수 충족
                counts[numbers[end]]++;
                end++;
                max = Math.max(end - start, max);
            } else {
                // 개수 초과
                counts[numbers[start]]--;
                start++;
            }
        }

        bw.write(Integer.toString(max));
        bw.flush();
    }
}
