import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // n번째 원소를 마지막으로 가지면서 가장 큰 최대갯수
        int[] dp = new int[count];
        Arrays.fill(dp, 1);

        int result = 1;

        for (int i = 1; i < count; i++) {
            // i보다 앞에있는 원소들 중에서
            for (int j = 0; j < i; j++) {
                //  arr[i]보다 작으면서, 가장 큰 최대 갯수를 가지는 값 찾기
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);

    }
}
