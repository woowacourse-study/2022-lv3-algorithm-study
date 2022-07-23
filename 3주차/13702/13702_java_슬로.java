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
        int maxAmount = 0;
        int[] amounts = new int[N];
        for (int i = 0; i < N; i++) {
            amounts[i] = Integer.parseInt(br.readLine());
            maxAmount = Math.max(maxAmount, amounts[i]);
        }

        System.out.println(calculate(N, K, amounts, maxAmount));
    }

    private static long calculate(int N, int K, int[] amounts, int maxAmount) {
        long left = 1;
        long right = maxAmount;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            int total = 0;
            for (int i = 0; i < N; i++) {
                total += amounts[i] / mid;
            }
            if (total >= K) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
