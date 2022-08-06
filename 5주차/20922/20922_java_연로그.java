import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 💥 계속 시간 초과가 나서 다른 사람 풀이를 보고 풀었습니다

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        // calculate
        int max = 0;
        int start = 0;
        int end = 0;
        int[] counts = new int[100001];

        while (end < N) {
            while (end < N && counts[arr[end]] + 1 <= K) {
                counts[arr[end++]]++;
            }

            max = Math.max(end - start, max);
            counts[arr[start++]]--;
        }
        System.out.println(max);
        br.close();
    }
}
