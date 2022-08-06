import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int max = 0;
        int[] cnt = new int[100001];

        while (s <= e && e < N)  {
            int a = numbers[e];
            if (cnt[a] < K) {
                cnt[a]++;
                max = Math.max(max, e - s + 1);
                e++;
                continue;
            }
            cnt[numbers[s]]--;
            s++;
        }

        System.out.println(max);
    }
}
