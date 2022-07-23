import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java_13702_루키 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] bottle = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            bottle[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, bottle[i]);
        }

        int low = 0;
        int high = max;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;

            for (int num : bottle) {
                cnt += num / mid;
            }

            if (cnt >= K) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        System.out.println(high);
    }
}
