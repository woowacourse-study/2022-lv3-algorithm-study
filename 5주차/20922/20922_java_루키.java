import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int max = 0;
        int[] cnt = new int[100001];

        while (start <= end && end < N)  {
            int index = numbers[end];
            if (cnt[index] < K) {
                cnt[index]++;
                max = Math.max(max, end - start + 1);
                end++;
                continue;
            }
            cnt[numbers[start]]--;
            start++;
        }

        System.out.println(max);
    }
}
