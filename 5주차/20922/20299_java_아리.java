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

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int start = 0;
        int end = 0;
        // 각 숫자의 사용 횟수
        int[] nums = new int[100001];

        while (start <= end && start < N) {
            // 조건 만족한다면 사용횟수, end ++
            if (end < N && nums[arr[end]] < K) {
                nums[arr[end]]++;
                end++;
            }

            // 조건 만족 ㄴㄴ~  start++
            else {
                nums[arr[start]]--;
                start++;
            }

            result = Math.max(result, end - start);
        }

        System.out.println(result);
    }

}
