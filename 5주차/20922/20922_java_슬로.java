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
        int[] count = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < N) {
            if (count[numbers[right]] < K) {
                count[numbers[right]]++;
                right++;
            } else {
                count[numbers[left]]--;
                left++;
            }
            max = Math.max(max, right - left);
        }
        System.out.println(max);
    }
}
